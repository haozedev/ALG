package com.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName KillDemo
 * @Description 秒杀demo
 * @Author ty-ChaiHaoZe
 * @Date 2022/5/28
 * @Version 0.1.0
 * @History 首次
 **/
public class KillDemo {
    /**
     * @Description 启动10个线程，库存6个，生成一个合并队列，每个用户能拿到自己的请求响应
     * @Param args
     * @Return void
     * @Author ty-ChaiHaoZe
     * @Date 2022/5/28
     **/
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        KillDemo killDemo = new KillDemo();
        killDemo.mergeJob();
        Thread.sleep(2000);

        List<Future<Result>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final Long orderId = i + 100L;
            final Long userId = Long.valueOf(i);
            Future<Result> future = executorService.submit(() -> {
                return killDemo.operate(new UserRequest(orderId, userId, 1));
            });
            futureList.add(future);
        }
        futureList.forEach(future -> {
            try {
                Result result = future.get(300, TimeUnit.MILLISECONDS);
                System.out.println(Thread.currentThread().getName() + "客户端请求响应" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    //库存
    private Integer stock = 6;
    //阻塞队列
    private BlockingDeque<RequestPromise> queue = new LinkedBlockingDeque<>(10);

    /**
     * @Description 用户库存扣减 wait.notify
     * @Param
     * @Return com.dev.Result
     * @Author ty-ChaiHaoZe
     * @Date 2022/5/28
     **/
    public Result operate(UserRequest userRequest) throws InterruptedException {
        RequestPromise requestPromise = new RequestPromise(userRequest);

        boolean enqueueSuccess = queue.offer(requestPromise, 100, TimeUnit.MILLISECONDS);
        if (!enqueueSuccess) {
            return new Result(false, "系统繁忙");
        }

        synchronized (requestPromise) {
            try {
                requestPromise.wait(200);
            } catch (InterruptedException e) {
                return new Result(false, "等待超时");
            }
        }
        return requestPromise.getResult();
    }

    /**
     * @Description 异步线程
     * @Param
     * @Return void
     * @Author ty-ChaiHaoZe
     * @Date 2022/5/28
     **/
    public void mergeJob() {
        new Thread(() -> {
            List<RequestPromise> list = new ArrayList<>();
            while (true) {
                if (queue.isEmpty()) {
                    try {
                        Thread.sleep(10);
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (queue.peek() != null) {
                    list.add(queue.poll());
                }

                System.out.println(Thread.currentThread().getName() + ":合并扣减库存" + list);

                int sum = list.stream().mapToInt(e -> e.getUserRequest().getCount()).sum();

                //两种情况
                if (sum <= stock) {
                    sum -= sum;
                    //notify user
                    list.forEach(requestPromise -> {
                        requestPromise.setResult(new Result(true, "ok"));
                        synchronized (requestPromise) {
                            requestPromise.notify();
                        }
                    });
                    continue;

                }

                for (RequestPromise requestPromise : list) {
                    Integer count = requestPromise.getUserRequest().getCount();
                    if (count <= stock) {
                        stock -= count;
                        requestPromise.setResult(new Result(true, "ok"));
                        synchronized (requestPromise) {
                            requestPromise.notify();
                        }
                    } else {
                        requestPromise.setResult(new Result(false, "库存不足"));
                    }
                }


            }
        }, "mergeThread").start();
    }
}

class RequestPromise {
    private UserRequest userRequest;
    private Result result;

    public RequestPromise(UserRequest userRequest) {
        this.userRequest = userRequest;
    }

    public UserRequest getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(UserRequest userRequest) {
        this.userRequest = userRequest;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RequestPromise{" +
                "userRequest=" + userRequest +
                ", result=" + result +
                '}';
    }
}


class Result {
    private boolean success;
    private String msg;

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                '}';
    }
}

class UserRequest {
    private Long orderId;
    private Long userId;
    private Integer count;

    public UserRequest(Long orderId, Long userId, Integer count) {
        this.orderId = orderId;
        this.userId = userId;
        this.count = count;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", count=" + count +
                '}';
    }
}

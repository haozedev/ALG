package com.dev.interfaces;

public class AsyncTask implements Runnable {
    private TaskCallback callback;

    public AsyncTask(TaskCallback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        // 模拟异步任务
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = "Task completed successfully";
        callback.onComplete(result);
    }
}

package com.GC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author
 * @des: 漏桶算法
 * @date 2021年6月22日 上午11:10:30
 * @package nan.yao.cui.others.aboutbuckets
 */
public class BucketTest {

    // 桶的容量
    private int capacity = 100;

    // 木桶剩余的水滴的量(初始化的时候的空的桶)
    private AtomicInteger water = new AtomicInteger(0);

    // 水滴的流出的速率,这个可以在 构造方法种设置,比如每秒10个请求.
    private int outRate;

    // 记录上次成功接收到请求的时间
    // 用于计算当前系统时间减去上次请求时间 乘以outrate 所处理的请求数.
    private long receivedTime;

    // 判断该controller是否能继续接收请求
    // true:表示可以处理该请求
    // false:表示不能处理该请求,漏桶已经满了
    public boolean acquire() {

	// 如果是空桶,则直接将
	if (water.get() == 0) {

	    receivedTime = System.currentTimeMillis();
	    water.addAndGet(1);
	    return true;

	}

	// 先计算下上成功接受到当前时间已经流出的记录数
	int outNum = ((int) ((System.currentTimeMillis() - receivedTime) / 1000)) * outRate;
	int waterLeft = water.get() - outNum;
	water.set(Math.max(0, waterLeft));
	// 重新更新leakTimeStamp
	// outNum是否大于0---cuiyaonan2000@163.com
	if (outNum > 0) {
	    receivedTime = System.currentTimeMillis();
	}

	// 尝试加水,并且水还未满
	if ((water.get()) < capacity) {
	    water.addAndGet(1);
	    return true;
	} else {
	    // 水满，拒绝加水
	    return false;
	}
    }

    public static void main(String[] args) {
	System.out.println((((System.currentTimeMillis() - 100) / 1000) * 2));
	System.out.println(System.currentTimeMillis() - 100);
	System.out.println((System.currentTimeMillis() - 100) / 1000);

    }

}

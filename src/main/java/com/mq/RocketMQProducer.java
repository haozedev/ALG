package com.mq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @ClassName RocketMQ
 * @Author haoZe
 * @Date 2023/6/26
 **/
public class RocketMQProducer {
    public static void main(String[] args) throws Exception {
        //1.创建一个发送消息的对象Producer
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        //2.设定发送的命名服务器地址
        producer.setNamesrvAddr("192.168.200.128:9876");
        //3.1启动发送的服务
        producer.start();
        for (int i = 1; i <= 10; i++) {
            //4.创建要发送的消息对象,指定topic，指定内容body
            Message msg = new Message("topic1",("hello rocketmq "+i).getBytes("UTF-8"));
            //3.2发送消息
            SendResult result = producer.send(msg);
            System.out.println("返回结果："+result);
        }
        //5.关闭连接
        producer.shutdown();
    }
}

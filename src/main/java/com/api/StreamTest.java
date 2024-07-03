package com.api;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName StreamTest
 * @Author haoZe
 * @Date 2024/6/11
 **/
public class StreamTest {

    public static void main(String[] args) {
//        List<Person> per = List.of(
//                new Person("Tom", 18, "China"),
//                new Person("Jerry", 9, "American"),
//                new Person("LiHua", 19, "American"),
//                new Person("Stephen", 59, "UK"),
//                new Person("Jack", 70, "HongKong")
//        );
//        Stream<Person> personStream = per.stream();
//
//        Stream<String> nameStream = personStream.map(Person::getName);
//
//        nameStream.forEach(System.out::println);

//        int a = 20;
//        int b = 20;
//        boolean bo1 = ((++a % 3) == 0) && ((a++ % 7) == 0);
//        System.out.println("bo1的值：" + bo1);
//        System.out.println("a的值：" + a);
//        System.out.println("----------------------------");
//
//        boolean bo2 = ((b++ % 3) == 0) && ((++b % 7) == 0);
//        System.out.println("bo2的值：" + bo2);
//        System.out.println("b的值：" + b);
//        int sum =0;
//        for(int i = 0;i<10;i++){
//            sum = sum+i;
//        }
//        System.out.println("sum="+sum);

//        char ab = '\u0036';
//        System.out.println(ab);

//        Scanner input = new Scanner(System.in);
//
//        String next = input.next();
//
//        System.out.println(next);
//
//        int [] arr = {1,2,3};
//        OptionalDouble average = Arrays.stream(arr).average();
//        System.out.println(average);
//        int num = 0;
//        for(System.out.println("这是初始化");num < 3;System.out.println(num),num++){
//            System.out.println("还能这么写");
//        }

//        for (int i=100;i<=999;i++){
//            int ge = i % 10;
//            int shi = i / 10 % 10;
//            int bai = i / 100;
//
//            if (ge*ge*ge + shi*shi*shi + bai * bai * bai ==i ){
//                System.out.println(i);
//            }
//        }

        try {
            InetAddress inet1 = InetAddress.getByName("192.168.31.58");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            InetAddress host = InetAddress.getLocalHost();
            System.out.println(host);

            InetAddress[] name = InetAddress.getAllByName("127.0.0.1");
            System.out.println(name);

            //2.两个常用方法
            System.out.println(inet2.getHostName());
            System.out.println(inet2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void client() {
        //create socket
        Socket clientSocket = null;
        OutputStream outputStream = null;
        try {
            InetAddress name = InetAddress.getByName("192.168.31.58");
            int port = 8089;
            clientSocket = new Socket(name, port);
            //send data
            outputStream = clientSocket.getOutputStream();
            outputStream.write("HI,I'M".getBytes());

            //close socket
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void server(){

        //create socket
        int port = 8089;
        ServerSocket serverSocket = null;
        Socket accept = null;//会阻塞
        InputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(8089);
            accept = serverSocket.accept();


            inputStream = accept.getInputStream();

            byte[] buffer = new byte[4];

            int len;

            while ((len = inputStream.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.println(str);
            }
            System.out.println("数据接收完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

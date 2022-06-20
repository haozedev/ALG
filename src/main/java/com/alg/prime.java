package com.alg;

import java.util.Scanner;

/**
 * @ClassName prime
 * @Description HJ6 质数因子
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/14
 * @Version TODO
 * @History TODO
 **/
public class prime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();
        long k = (long) Math.sqrt(num);

        for (long i = 2; i <= k; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println(num == 1 ? "": num+" ");
    }
}

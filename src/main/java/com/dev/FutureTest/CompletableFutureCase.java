package com.dev.FutureTest;


import org.apache.commons.lang.StringUtils;

/**
 * @ClassName CompletableFutureCase
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/8/30
 * @Version TODO
 * @History TODO
 **/
public class CompletableFutureCase {
    public static void main(String[] args) {
        String s = "   ";
        boolean empty = StringUtils.isNotEmpty(s);
        System.out.println(empty);
        boolean empty1 = StringUtils.isNotEmpty(s.trim());
        System.out.println(empty1);
    }
}
class NetMall{

}

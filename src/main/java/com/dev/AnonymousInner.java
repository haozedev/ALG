package com.dev;

/**
 * @ClassName AnonymousInner
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/13
 * @Version TODO
 * @History TODO
 **/
interface Swimming{
    void swim();
}


public class AnonymousInner {
    public static void main(String[] args) {
        goSwimming(new Swimming() {
            @Override
            public void swim() {
                System.out.println("匿名内部类");
            }
        });

        goSwimming(()-> System.out.println("Lambda表达式实现"));
    }

    /**
     *@Description 接口对象为入参，调用接口内方法必须重写
     *@Param swimming
     *@Return void
     *@Author ty-ChaiHaoZe
     *@Date 2022/6/13
     **/
    public static void goSwimming(Swimming swimming){
        swimming.swim();
    }
}

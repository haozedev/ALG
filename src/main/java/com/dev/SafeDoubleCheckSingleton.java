package com.dev;

/**
 * @ClassName SafeDoubleCheckSingleton
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/6/17
 * @Version TODO
 * @History TODO
 **/
public class SafeDoubleCheckSingleton {

    //加上volatile关键字，防止指令重排，返回为 null
    private volatile static SafeDoubleCheckSingleton singleton;

    private SafeDoubleCheckSingleton(){

    }
    public SafeDoubleCheckSingleton getInstance(){

        if (singleton==null){
            synchronized (SafeDoubleCheckSingleton.class){
                if (singleton==null){
                    singleton = new SafeDoubleCheckSingleton();
                }
            }
        }

        return singleton;
    }

}

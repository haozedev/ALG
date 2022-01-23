package com.tec.mode;

/**
 * @author HaoZ
 * @create 2021/12/4 15:29
 */
public class Singleton {
        private static String TAG = "Singleton";
        private static Singleton singleton = new Singleton();
        //单例模式特点，构造必须私有
        private Singleton(){

        }

        private static Singleton getInstance(){
                return singleton;
        }
        public void hungry(){
                System.out.println("Please call me 饥饿鬼");
        }
}

package com.dev.interfaces;

public class Client {
    public static void main(String[] args) {
        Integer integer = new Integer(1);
        TaskCallback callback = new TaskCallback() {
            @Override
            public void onComplete(String result) {
                System.out.println(result);
            }
        };
        new Thread(new AsyncTask(callback)).start();
    }
}

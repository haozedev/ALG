package com.tec;

import org.openjdk.jol.info.ClassLayout;

public class JOLDemo {
    public static void main(String[] args) {

        Custom custom = new Custom();
        custom.setName("tom");
        custom.setId(100);
        System.out.println(ClassLayout.parseInstance(custom).toPrintable());

    }
    @lombok.Data
    static class Custom {
        boolean flag = false;
        private int id;
        private Long number;
        private Double money;
        private String name;
    }
}

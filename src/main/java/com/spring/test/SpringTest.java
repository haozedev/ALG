package com.spring.test;

import com.spring.applicationContext.AnnotationConfigApplicationContext;
import com.spring.test.config.AppConfig;


/**
 * @author haoze
 * @create 2025/3/24 13:37
 * @description
 */
public class SpringTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        //applicationContext.getBean();
    }
}

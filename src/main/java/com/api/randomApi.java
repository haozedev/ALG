package com.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName randomApi
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/9/6
 * @Version TODO
 * @History TODO
 **/
public class randomApi {
    public static void main(String[] args) {
        String num = "123456";

        int i = 0;

        Logger logger = LoggerFactory.getLogger(randomApi.class);

        logger.info("日志{},{}",num,i);

    }
}

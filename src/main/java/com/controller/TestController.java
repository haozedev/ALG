package com.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haoze
 * @create 2025/4/25 9:33
 * @description
 */


@RequestMapping("/api")
@RestController
public class TestController {



    @PostMapping("/save")
    public String saveTest(){
        return "success";
    }

}


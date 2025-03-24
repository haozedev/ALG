package com.spring.test.bean;


import com.spring.annotation.Scope;
import com.spring.annotation.Service;

/**
 * @author haoze
 * @create 2025/3/24 16:13
 * @description
 */
@Service("userService1")
@Scope("singleton")
public class UserService1 {
}

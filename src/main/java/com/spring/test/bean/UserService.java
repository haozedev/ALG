package com.spring.test.bean;

import com.spring.annotation.Scope;
import com.spring.annotation.Service;

/**
 * @author haoze
 * @create 2025/3/24 14:39
 * @description
 */
@Service("userService")
@Scope("prototype")
public class UserService {
}

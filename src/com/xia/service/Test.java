package com.xia.service;

import com.xia.spring.XiaApplicationContext;

/**
 * @author xwfstart
 * @create 2022-06-23 23:53
 */
public class Test {
    public static void main(String[] args) {
        XiaApplicationContext applicationContext = new XiaApplicationContext(AppConfig.class);
//        System.out.println(applicationContext.getBean("userService"));
//        System.out.println(applicationContext.getBean("orderService"));
//        UserService userService = (UserService) applicationContext.getBean("userService");
        UserInterface userService = (UserInterface) applicationContext.getBean("userService");  // 通过动态代理,返回的是是实现UserInterface接口的对象
        userService.test();

    }
}

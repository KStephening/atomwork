package com.oarage.spring.helloworld.impl;

import com.oarage.spring.helloworld.HelloWorld;

/**
 * @program: spring
 * @description:
 * @author: PuTao
 * @create: 2018-08-21 17:54
 **/
public class SpringHelloWorld implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.println("Spring Say Hello!!");
    }
}

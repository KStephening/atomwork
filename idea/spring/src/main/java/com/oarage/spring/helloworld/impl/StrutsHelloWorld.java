package com.oarage.spring.helloworld.impl;

import com.oarage.spring.helloworld.HelloWorld;

/**
 * @program: spring
 * @description:
 * @author: PuTao
 * @create: 2018-08-21 17:54
 **/
public class StrutsHelloWorld implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.println("Struts Say Hello!!");
    }
}

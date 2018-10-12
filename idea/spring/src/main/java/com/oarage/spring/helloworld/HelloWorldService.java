package com.oarage.spring.helloworld;

/**
 * @program: spring
 * @description:
 * @author: PuTao
 * @create: 2018-08-21 17:52
 **/
public class HelloWorldService {

    private HelloWorld helloWorld;

    public HelloWorldService() {

    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public HelloWorld getHelloWorld() {
        return this.helloWorld;
    }
}

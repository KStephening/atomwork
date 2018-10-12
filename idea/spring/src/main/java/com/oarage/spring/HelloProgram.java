package com.oarage.spring;

import com.oarage.spring.helloworld.HelloWorld;
import com.oarage.spring.helloworld.HelloWorldService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring
 * @description:
 * @author: PuTao
 * @create: 2018-08-21 17:51
 **/
public class HelloProgram {

    public static void main(String[] args) {

        /*通过bean1.xml获取配置*/
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        /*这里会在bean1.xml寻找相应的实现类  --SpringHelloWorld或--StrutsHelloWorld*/
        HelloWorldService service =
                (HelloWorldService) context.getBean("helloWorldService");

        HelloWorld hw = service.getHelloWorld();

        hw.sayHello();
    }
}

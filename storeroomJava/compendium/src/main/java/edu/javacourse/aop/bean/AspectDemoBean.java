package edu.javacourse.aop.bean;

import org.springframework.stereotype.Component;

@Component
public class AspectDemoBean {
    //    public void  methodOne() {
//        System.out.println("We are calling method ONE");
//    }
    public String methodOne(String comment) {
        System.out.println("We are calling method ONE");
        if ("EXCEPTIONS".equalsIgnoreCase(comment)) {
            throw new RuntimeException("Error for massage " + comment);
        }
        return "Hello " + comment;
    }

    public void methodTwo() {
        System.out.println("We are calling method TWO");
    }
}

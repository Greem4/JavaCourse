package edu.javacourse.aop;

import edu.javacourse.aop.bean.AspectDemoBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        AspectDemoBean adb = context.getBean(AspectDemoBean.class);
        adb.methodOne("Greem");
        try {
            adb.methodOne("Exceptions");
        }catch (Exception e) {
            System.out.println("ERROR");
        }
//        adb.methodTwo();
    }
}

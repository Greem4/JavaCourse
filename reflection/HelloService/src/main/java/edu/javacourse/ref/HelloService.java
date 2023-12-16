package edu.javacourse.ref;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class HelloService {

    public static void main(String[] args) throws Exception {
        ClassLoader system = ClassLoader.getSystemClassLoader();
//        ClassLoader ext = system.getParent();
//
//        System.out.println(ext.getParent());
//        System.out.println(ext);
//        System.out.println(system);

        URLClassLoader cl1 = new URLClassLoader(new URL[]{
                new URL("file:///home/greem/ideaProjects/JavaCourse/reflection/SimpleHello/out/artifacts/hello1_1/hello1-1.jar")
        }, system);

        URLClassLoader cl2 = new URLClassLoader(new URL[]{
                new URL("file:///home/greem/ideaProjects/JavaCourse/reflection/SimpleHello2/out/artifacts/Hello2/Hello2.jar")
        }, cl1);

        Class clazz = Class.forName("edu.javacourse.ref.hello.Hello1", true, cl1);
        Method m = clazz.getMethod("sayHello");
        Object obj = clazz.newInstance();
        m.invoke(obj);

        Class clazz2 = Class.forName("edu.javacourse.ref.hello.Hello2", true, cl2);
        Method m2 = clazz2.getMethod("sayHello2");
        Object obj2 = clazz2.newInstance();
        m2.invoke(obj2);
    }
}

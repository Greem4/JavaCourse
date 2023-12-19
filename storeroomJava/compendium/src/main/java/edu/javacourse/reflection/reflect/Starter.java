package edu.javacourse.reflection.reflect;

import java.lang.reflect.Field;

public class Starter {
    public static void main(String[] args) throws Exception {
        Class<?> cl1 = Class.forName("edu.javacourse.reflection.reflect.Second");
        Second o =(Second) cl1.newInstance();

        Field field = cl1.getSuperclass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(o, "name");

        Field field2 = cl1.getDeclaredField("name1");
        field2.setAccessible(true);
        field2.set(o, "name1");

        System.out.println(o.getName());
        System.out.println(o.getName1());

        System.out.println(Object.class.getSuperclass());
    }
}

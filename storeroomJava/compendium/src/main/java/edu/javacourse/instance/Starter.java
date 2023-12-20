package edu.javacourse.instance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Starter {
    public static void main(String[] args) {
        Class<First> cl = First.class;

        try {
            Constructor<First> cns = cl.getDeclaredConstructor(String.class);
            cns.setAccessible(true);
            First f = cns.newInstance("TEST");
            System.out.println(f.getName());
        } catch (InstantiationException e) {
            e.printStackTrace(System.out);
        } catch (IllegalAccessException e) {
            e.printStackTrace(System.out);
        } catch (NoSuchMethodException e) {
            e.printStackTrace(System.out);
        } catch (InvocationTargetException e) {
            e.printStackTrace(System.out);
        }

        System.out.println("FINISH");
    }
}

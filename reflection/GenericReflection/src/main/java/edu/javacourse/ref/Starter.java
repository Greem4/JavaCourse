package edu.javacourse.ref;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class Starter {
    public static void main(String[] args) throws Exception {
//        demoFirst();
        demoGeneric();
    }

    private static void demoGeneric() throws Exception {
        Class cl = GenericSimple.class;
        Method m = cl.getMethod("findSomething", Map.class, Integer.class);
        Type[] pts = m.getGenericParameterTypes();
        for (Type p : pts) {
            System.out.println("Name:" + p.getTypeName());
            if (p instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType)p;
                System.out.println("in 1:" + pt.getActualTypeArguments()[0]);
                System.out.println("in 2:" + pt.getActualTypeArguments()[1]);
            }
        }

        Type rt = m.getGenericReturnType();
        if (rt instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType)rt;
            System.out.println("out 1:" + pt.getActualTypeArguments()[0]);
        }
    }


    private static void demoFirst() throws Exception {
        Class cl = GenericSimple.class;
        Method m = cl.getMethod("test", Integer.class, int.class, String.class);
        System.out.println("Method: " + m.getName());
        Class<?>[] pts = m.getParameterTypes();
        for (Class p : pts) {
            System.out.println(p.getCanonicalName());
        }
        Class<?> rt = m.getReturnType();
        System.out.println("Return:" + rt.getCanonicalName());
    }
}

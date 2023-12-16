package edu.javacourse.jb;

import java.beans.*;
import java.lang.reflect.Method;

public class Starter {
    public static void main(String[] args) throws Exception {
        BeanInfo bi = Introspector.getBeanInfo(Hello.class);

        PropertyDescriptor[] pds = bi.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            if (!"class".equals(pd.getName())) {
                System.out.println(pd.getName());
                Method r = pd.getReadMethod();
                System.out.println("Read:" + r);
                Method w = pd.getWriteMethod();
                System.out.println("Write:" + w);
            }
        }

        MethodDescriptor[] mds = bi.getMethodDescriptors();
        for (MethodDescriptor md : mds) {

        }
    }
}

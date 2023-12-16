package edu.javacourse.ref;

import edu.javacourse.ref.annotation.Generator;

import java.beans.BeanInfo;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class PasswordFactory {

    public static String getPassword() {
        try {
            String clazz = getGenerator();
            Class<?> genClass = Class.forName(clazz);

            Method[] methods = genClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Check method:" + method.getName());
                Generator ann = method.getAnnotation(Generator.class);
                if (ann != null) {
                    Object generator = createObject(genClass);
                    method.setAccessible(true);
                    String pswd = (String) method.invoke(generator);
                    return pswd;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return "";
    }

    private static String getGenerator() throws IOException {
        Properties p = new Properties();
        p.load(new FileReader("generator.properties"));
        return p.getProperty("generator.class");
    }

    private static Object createObject(Class clazz) throws Exception {
        Constructor constr = clazz.getDeclaredConstructor(String.class, String.class);
        constr.setAccessible(true);
        Object obj = constr.newInstance("FromConstructorAlg", "FromConstructorName");
//        return obj;
        return fillProperties(obj);
    }

    private static Object fillProperties(Object obj) throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("generator.properties"));

        for (String str : p.stringPropertyNames()) {
            if (!"generator.class".equals(str)) {
                String value = p.getProperty(str);
//                System.out.println("Property:" + str + "=" + value);
            }
        }
        return obj;
    }
}

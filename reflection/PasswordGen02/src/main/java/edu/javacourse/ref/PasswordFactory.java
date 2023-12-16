package edu.javacourse.ref;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class PasswordFactory {

    public static String getPassword() {
        try {
            String clazz = getGenerator();
            Class<?> genClass = Class.forName(clazz);
            Object generator = genClass.newInstance();
            System.out.println(generator.getClass().getCanonicalName());

            String methodStr = getMethod();
            Method method = genClass.getMethod(methodStr);
            System.out.println(method.getName());

            String pswd = (String) method.invoke(generator);
            return pswd;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return "";
    }

    private static String getGenerator() throws IOException {
        Properties p = new Properties();
        p.load(new FileReader("generator.properties"));
        return p.getProperty("generator");
    }

    private static String getMethod() throws IOException {
        Properties p = new Properties();
        p.load(new FileReader("generator.properties"));
        return p.getProperty("method");
    }
}

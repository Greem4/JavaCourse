package edu.javacourse.ref;

import edu.javacourse.ref.annotation.Generator;

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

            Method[] methods = genClass.getMethods();
            for (Method method : methods) {
                System.out.println("Check method:" + method.getName());
                Generator ann = method.getAnnotation(Generator.class);
                if (ann != null) {
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
        return p.getProperty("generator");
    }
}

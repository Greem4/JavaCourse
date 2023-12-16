package edu.javacourse.ref;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PasswordGeneratorFactory {

    public static PasswordGenerator getPasswordGenerator() {
        try {
            String clazz = getGenerator();
            Class<?> genClass = Class.forName(clazz);
//            System.out.println(genClass.getCanonicalName());
            PasswordGenerator generator =(PasswordGenerator) genClass.newInstance();
            return generator;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return new PasswordGeneratorFirst();
    }

    private static String getGenerator() throws IOException {
        Properties p = new Properties();
        p.load(new FileReader("generator.properties"));
        return p.getProperty("generator");
    }
}

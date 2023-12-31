package edu.javacourse.inteface.interface3;

import java.util.ServiceLoader;

public interface Hello {
    void sayHello();

    String getName();

    static Hello getInstance(String name) {
        ServiceLoader<Hello> services = ServiceLoader.load(Hello.class);

        for (Hello hello : services) {
            if (hello.getName().equals(name)) {
                return hello;
            }
        }
        throw new RuntimeException("No such implementation" + name);
    }
}

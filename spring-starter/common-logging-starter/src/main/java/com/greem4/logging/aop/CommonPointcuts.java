package com.greem4.logging.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonPointcuts {

    /*
        @within - check annotation on the class level
                  проверьте аннотацию на уровне класса
     */
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayers() {
    }

    /*
        within - check class type name
                 проверить имя типа класса
     */
    @Pointcut("within(com.greem4.*.service.*Service)")
    public void isServiceLayers() {
    }
}

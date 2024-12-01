package com.greem4.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
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
    @Pointcut("within(com.greem4.spring.service.*Service)")
    public void isServiceLayers() {
    }
}

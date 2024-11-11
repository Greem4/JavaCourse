package com.greem4.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FirstAspect {

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

    /*
        this - check AOP proxy class type
        target - check target object class type
     */
    @Pointcut("this(org.springframework.data.repository.Repository)")
//    @Pointcut("target(org.springframework.data.repository.Repository)")
    public void isRepositoryLayers() {
    }

    /*
        @annotation - check annotation on method level
                      проверить аннотацию на уровне метода
     */
    @Pointcut("isControllerLayers() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping() {

    }

    /*
        args - check method param type
        * - any param type
        .. - 0+ any params type
     */
    @Pointcut("isControllerLayers() && args(org.springframework.ui.Model,..)")
    public void hasModelParam() {

    }

    /*
        @args - check annotation on the param type
                проверьте аннотацию к типу параметра
        * - any param type
        .. - 0+ any params type
     */
    @Pointcut("@args(com.greem4.spring.validation.UserInfo)")
    public void hasUserInfoParamAnnotation() {}

    /*
        bean - check bean name
     */
    @Pointcut("bean(*Service)")
    public void isServiceLayerBean() {}

    /*
        execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)) throws
     */
    @Pointcut("execution(public * com.greem4.spring.service.*Service.finById(*))")
    public void anyFindByIdServiceMethod() {}
}

package com.greem4.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Aspect
@Component
@Order(1)
public class FirstAspect {

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
    @Pointcut("com.greem4.spring.aop.CommonPointcuts.isControllerLayers()ers() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping() {

    }

    /*
        args - check method param type
        * - any param type
        .. - 0+ any params type
     */
    @Pointcut("com.greem4.spring.aop.CommonPointcuts.isControllerLayers()rs() && args(org.springframework.ui.Model,..)")
    public void hasModelParam() {

    }

    /*
        @args - check annotation on the param type
                проверьте аннотацию к типу параметра
        * - any param type
        .. - 0+ any params type
     */
    @Pointcut("@args(com.greem4.spring.validation.UserInfo)")
    public void hasUserInfoParamAnnotation() {
    }

    /*
        bean - check bean name
     */
    @Pointcut("bean(*Service)")
    public void isServiceLayerBean() {
    }

    /*
        execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)) throws
     */
    @Pointcut("execution(public * com.greem4.spring.service.*Service.findById(*))")
    public void anyFindByIdServiceMethod() {
    }

    @Before(value = "anyFindByIdServiceMethod() " + "&& args(id) " + "&& target(service) " + "&& this(serviceProxy) " + "&& @within(transactional) ", argNames = "joinPoint,id,service,serviceProxy,transactional")
    public void addLogging(JoinPoint joinPoint, Object id, Object service, Object serviceProxy, Transactional transactional) {
        log.info("before - invoked findById method in class {}, with id {}", service, id);
    }

    @AfterReturning(value = "anyFindByIdServiceMethod()" + "&& target(service)", returning = "result")
    public void addLoggingAfterReturning(Object result, Object service) {
        log.info("after returning - invoked findById method in class {}, result {}", service, result);
    }

    @AfterThrowing(value = "anyFindByIdServiceMethod()" + "&& target(service)", throwing = "ex")
    public void addLoggingAfterThrowable(Throwable ex, Object service) {
        log.info("after throwing - invoked findById method in class {}, exception {}: {}", service, ex.getClass(), ex.getMessage());
    }

    @After("anyFindByIdServiceMethod() && target(service)")
    public void addLoggingAfterFinally(Object service) {
        log.info("after (finally) - invoked findById method in class {}", service);
    }

}

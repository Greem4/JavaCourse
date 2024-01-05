package edu.javacourse.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDemo {
    @Before("execution(public String edu.javacourse.aop.bean.AspectDemoBean.*(..))")
    public void checkCall(JoinPoint point) {
        System.out.println("Метод вызван: " + point.getSignature().getName());
    }

    @Around("execution(public String edu.javacourse.aop.bean.AspectDemoBean.*(..))")
    public Object checkAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Method - started: " + point.getSignature().getName());
        Object retVal = point.proceed();
        System.out.println("Method - finished: " + point.getSignature().getName());
        return retVal;
    }

    @After("execution(public String edu.javacourse.aop.bean.AspectDemoBean.*(..))")
    public void afterTest(JoinPoint point) {
        System.out.println("After all: " + point.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(public String edu.javacourse.aop.bean.AspectDemoBean.*(..))",
            returning = "retVal")
    public void afterRetiringTest(JoinPoint point, Object retVal) {
        System.out.println("Return parameter: " + retVal);
    }

    @AfterThrowing(pointcut = "execution(public String edu.javacourse.aop.bean.AspectDemoBean.*(..))",
            throwing = "error")
    public void afterThrowingTest(JoinPoint point, Exception error) {
        error.printStackTrace(System.out);
    }
}

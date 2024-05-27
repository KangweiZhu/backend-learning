package com.anicaaz.springplayground.aop;

import org.myspringframework.annotation.Around;
import org.myspringframework.annotation.Aspect;
import org.myspringframework.aop.ProceedingJoinPoint;

@Aspect
public class Log {

    @Around(execution = "com.anicaaz.springplayground.service.impl.UserServiceImpl.add()")
    public void logDataBase(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Before");
        proceedingJoinPoint.proceed();
        System.out.println("After");
    }
}

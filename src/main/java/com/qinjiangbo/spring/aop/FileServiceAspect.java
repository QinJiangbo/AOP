package com.qinjiangbo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @date: 25/12/2016 11:41 AM
 * @author: qinjiangbo@github.io
 */
@Aspect
@Component
public class FileServiceAspect {

    @Around("execution(* com.qinjiangbo.spring.aop.FileService.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return null;
    }
}

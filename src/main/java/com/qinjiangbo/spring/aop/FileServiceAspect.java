package com.qinjiangbo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @date: 25/12/2016 11:41 AM
 * @author: qinjiangbo@github.io
 */
@Aspect
@Component
public class FileServiceAspect {

    @Around("execution(* com.qinjiangbo.spring.aop.FileService.copy(..))")
    public Object exeAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logBefore(proceedingJoinPoint);
        Object result = proceedingJoinPoint.proceed();
        logAfter(proceedingJoinPoint);
        return result;
    }

    @Around("@annotation(SysLog)")
    public Object tagAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Log printed with @SysLog annotation.");
        Object result = proceedingJoinPoint.proceed();
        return result;
    }

    @Before("execution(* com.qinjiangbo.spring.aop.FileService.*(..))")
    public void exeBefore() throws Throwable {
        System.out.println("@Before executed!");
    }

    @AfterReturning("execution(* com.qinjiangbo.spring.aop.FileService.*(..))")
    public void exeAfterReturning() throws Throwable {
        System.out.println("@AfterReturning executed!");
    }

    /**
     * 记录方法执行前日志
     */
    private void logBefore(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println(this.getClass().getName() + " >>> " + "before " + proceedingJoinPoint.getSignature().getName() + " invoked!");
    }

    /**
     * 记录方法后日志
     */
    private void logAfter(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println(this.getClass().getName() + " >>> " + "after " + proceedingJoinPoint.getSignature().getName() + " invoked!");
    }
}

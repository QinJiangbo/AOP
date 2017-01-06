package com.qinjiangbo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @date: 25/12/2016 11:41 AM
 * @author: qinjiangbo@github.io
 */
@Aspect
@Component
public class FileServiceAspect {

    @Around("execution(* com.qinjiangbo.spring.aop.FileService.copy(..))")
    public Object exeAround(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        logBefore(proceedingJoinPoint);
        Object result = proceedingJoinPoint.proceed();
        logAfter(proceedingJoinPoint);
        return result;
    }

    @Around("@annotation(SysLog)")
    public Object tagAround(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        System.out.println("Log printed with @SysLog annotation.");
        Object result = proceedingJoinPoint.proceed();
        return result;
    }

    private void logBefore(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println(this.getClass().getName() + " @@@ " + "before "
                + proceedingJoinPoint.getSignature().getName() + " invoked!");
    }

    private void logAfter(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println(this.getClass().getName() + " @@@ " + "after "
                + proceedingJoinPoint.getSignature().getName() + " invoked!");
    }
}

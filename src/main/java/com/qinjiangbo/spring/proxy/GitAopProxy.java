package com.qinjiangbo.spring.proxy;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @date: 25/12/2016 10:33 AM
 * @author: qinjiangbo@github.io
 */
public class GitAopProxy implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(this.getClass().getName() + " >>> " + "after fork() invoked!");
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(this.getClass().getName() + " >>> " + "before fork() invoked!");
    }
}

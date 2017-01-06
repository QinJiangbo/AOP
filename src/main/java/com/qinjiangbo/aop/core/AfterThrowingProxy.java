package com.qinjiangbo.aop.core;

import com.qinjiangbo.aop.annotation.AfterThrowing;

import java.lang.reflect.Method;

/**
 * @date: 06/01/2017 3:55 PM
 * @author: qinjiangbo@github.io
 */
public class AfterThrowingProxy extends AbstractProxy {

    private AspectCut aspectCut;

    @Override
    public void advice(AspectCut aspectCut) {
        this.aspectCut = aspectCut;
    }

    @Override
    public void afterThrowing(Class<?> clazz, Method method, Object[] args, Throwable throwable) {
        aspectCut.proceed();
    }

    @Override
    public boolean filter(Class<?> clazz, Method method, Object[] args) {
        String methodName = method.getName();
        Method method0 = aspectCut.getMethod();
        String methodName0 = method0.getAnnotation(AfterThrowing.class).value();
        return methodName.equals(methodName0);
    }
}

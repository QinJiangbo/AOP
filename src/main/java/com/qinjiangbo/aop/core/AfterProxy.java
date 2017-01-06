package com.qinjiangbo.aop.core;

import com.qinjiangbo.aop.annotation.After;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @date: 06/01/2017 3:54 PM
 * @author: qinjiangbo@github.io
 */
public class AfterProxy extends AbstractProxy {

    private AspectCut aspectCut;

    @Override
    public void advice(AspectCut aspectCut) {
        this.aspectCut = aspectCut;
    }

    @Override
    public void after(Class<?> clazz, Method method, Object[] args) {
        aspectCut.proceed();
    }

    @Override
    public boolean filter(Class<?> clazz, Method method, Object[] args) {
        String methodName = method.getName();
        Method method0 = aspectCut.getMethod();
        String methodName0 = method0.getAnnotation(After.class).value();
        return methodName.equals(methodName0);
    }
}

package com.qinjiangbo.aop.core;

import com.qinjiangbo.aop.annotation.Before;

import java.lang.reflect.Method;

/**
 * @date: 06/01/2017 3:54 PM
 * @author: qinjiangbo@github.io
 */
public class BeforeProxy extends AbstractProxy {

    private AspectCut aspectCut;

    @Override
    public void advice(AspectCut aspectCut) {
        this.aspectCut = aspectCut;
    }

    @Override
    public void before(Class<?> clazz, Method method, Object[] args) {
        aspectCut.proceed();
    }

    @Override
    public boolean filter(Class<?> clazz, Method method, Object[] args) {
        String methodName = method.getName();
        Method method0 = aspectCut.getMethod();
        String methodName0 = method0.getAnnotation(Before.class).value();
        return methodName.equals(methodName0);
    }
}

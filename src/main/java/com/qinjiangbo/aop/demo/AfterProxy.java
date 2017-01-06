package com.qinjiangbo.aop.demo;

import com.qinjiangbo.aop.core.AbstractProxy;

import java.lang.reflect.Method;

/**
 * @date: 06/01/2017 1:28 PM
 * @author: qinjiangbo@github.io
 */
public class AfterProxy extends AbstractProxy{

    @Override
    public void afterReturning(Class<?> clazz, Method method, Object[] args) {
        System.out.println("After logging into system...");
    }
}

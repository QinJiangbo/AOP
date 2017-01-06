package com.qinjiangbo.aop.demo;

import com.qinjiangbo.aop.core.AbstractProxy;

import java.lang.reflect.Method;

/**
 * @date: 06/01/2017 1:28 PM
 * @author: qinjiangbo@github.io
 */
public class BeforeProxy extends AbstractProxy {

    @Override
    public void before(Class<?> clazz, Method method, Object[] args) {
        System.out.println("Before logging into system...");
    }
}

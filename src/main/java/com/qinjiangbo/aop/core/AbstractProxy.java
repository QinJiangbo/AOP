package com.qinjiangbo.aop.core;

import java.lang.reflect.Method;

/**
 * @date: 06/01/2017 12:34 PM
 * @author: qinjiangbo@github.io
 */
public abstract class AbstractProxy implements Proxy{

    @Override
    public void doProxy(ProxyChain proxyChain) {
        Class<?> clazz = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] args = proxyChain.getTargetArgs();

        try {
            before(clazz, method, args);
            proxyChain.doProxyChain();
            afterReturning(clazz, method, args);
        } catch (Throwable throwable) {
            afterThrowing(clazz, method, args, throwable);
        } finally {
            after(clazz, method, args);
        }

    }

    public void before(Class<?> clazz, Method method, Object[] args) {

    }

    public void afterReturning(Class<?> clazz, Method method, Object[] args) {

    }

    public void after(Class<?> clazz, Method method, Object[] args) {

    }

    public void afterThrowing(Class<?> clazz, Method method, Object[] args, Throwable throwable) {

    }
}

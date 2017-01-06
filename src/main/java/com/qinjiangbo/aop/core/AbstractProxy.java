package com.qinjiangbo.aop.core;

import java.lang.reflect.Method;

/**
 * @date: 06/01/2017 12:34 PM
 * @author: qinjiangbo@github.io
 */
public abstract class AbstractProxy implements Proxy {

    public abstract void advice(AspectCut aspectCut);

    @Override
    public void doProxy(ProxyChain proxyChain) {
        Class<?> clazz = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] args = proxyChain.getTargetArgs();

        if (filter(clazz, method, args)) {
            try {
                before(clazz, method, args);
                proxyChain.doProxyChain();
                afterReturning(clazz, method, args);

            } catch (Throwable throwable) {
                afterThrowing(clazz, method, args, throwable);
            } finally {
                after(clazz, method, args);
            }
        } else {
            proxyChain.doProxyChain();
        }

    }

    public boolean filter(Class<?> clazz, Method method, Object[] args) {
        return true;
    }

    /**
     * before the method executed
     *
     * @param clazz
     * @param method
     * @param args
     */
    public void before(Class<?> clazz, Method method, Object[] args) {

    }

    /**
     * after the method returns
     *
     * @param clazz
     * @param method
     * @param args
     */
    public void afterReturning(Class<?> clazz, Method method, Object[] args) {

    }

    /**
     * no matter how the method ends, the block will be executed</br>
     * same as finally in try...catch blocks
     *
     * @param clazz
     * @param method
     * @param args
     */
    public void after(Class<?> clazz, Method method, Object[] args) {

    }

    /**
     * after the method throws an exception or error
     *
     * @param clazz
     * @param method
     * @param args
     * @param throwable
     */
    public void afterThrowing(Class<?> clazz, Method method, Object[] args, Throwable throwable) {

    }
}

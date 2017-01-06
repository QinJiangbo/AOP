package com.qinjiangbo.aop.core;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @date: 06/01/2017 12:22 PM
 * @author: qinjiangbo@github.io
 */
public class ProxyChain {

    private List<Proxy> proxyList;
    private int currentProxyIndex;

    private Class<?> targetClass;
    private Object targetObject;
    private Method targetMethod;
    private Object[] targetArgs;
    private MethodProxy methodProxy;
    private Object methodResult;

    public ProxyChain(Class<?> targetClass, Object targetObject, Method targetMethod,
                      Object[] targetArgs, MethodProxy methodProxy, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.targetArgs = targetArgs;
        this.methodProxy = methodProxy;
        this.proxyList = proxyList;
    }


    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public Object[] getTargetArgs() {
        return targetArgs;
    }

    public MethodProxy getMethodProxy() {
        return methodProxy;
    }

    public Object getMethodResult() {
        return methodResult;
    }

    /**
     * proxy chain method for invoking each proxy
     */
    public void doProxyChain() {
        if (currentProxyIndex < proxyList.size()) {
            proxyList.get(currentProxyIndex++).doProxy(this);
        } else {
            try {
                methodResult = methodProxy.invokeSuper(targetObject, targetArgs);
            } catch (Throwable throwable) {
                throw new RuntimeException(throwable);
            }
        }
    }

}

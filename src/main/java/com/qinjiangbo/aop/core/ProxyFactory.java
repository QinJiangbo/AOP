package com.qinjiangbo.aop.core;

import com.qinjiangbo.aop.annotation.After;
import com.qinjiangbo.aop.annotation.AfterReturning;
import com.qinjiangbo.aop.annotation.AfterThrowing;
import com.qinjiangbo.aop.annotation.Before;
import com.qinjiangbo.aop.util.CollectionUtils;
import com.qinjiangbo.aop.util.ReflectionUtils;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * @date: 06/01/2017 12:29 PM
 * @author: qinjiangbo@github.io
 */
public class ProxyFactory {

    private Class<?> targetClass;
    private List<Proxy> proxyList;

    /**
     * create proxy factory with proxy list
     *
     * @param targetClass
     * @param proxyList
     */
    public ProxyFactory(Class<?> targetClass, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.proxyList = proxyList;
    }

    /**
     * create proxy factory with aspect object
     *
     * @param targetClass
     * @param aspect
     */
    public ProxyFactory(Class<?> targetClass, Object aspect) {
        this.targetClass = targetClass;
        proxyList = new LinkedList<>();
        List<Class<? extends Annotation>> annotations = CollectionUtils.newLinkedList(
                After.class, Before.class, AfterReturning.class, AfterThrowing.class);
        List<Method> methodList = ReflectionUtils.findAnnotatedMethods(aspect.getClass(), annotations);
        for (Method method : methodList) {
            Class<? extends Annotation> annotation = ReflectionUtils.findMethodAnnotation(method);
            AbstractProxy proxy = createAdviceProxy(annotation);
            proxy.advice(new AspectCut(method, aspect, null));
            proxyList.add(proxy);
        }
    }

    /**
     * create proxy
     * @param <T>
     * @return
     */
    public <T> T createProxy() {
        return (T) Enhancer.create(targetClass, (MethodInterceptor) (obj, method, args, proxy) -> {
            ProxyChain proxyChain = new ProxyChain(targetClass, obj, method, args, proxy, proxyList);
            proxyChain.doProxyChain();
            return proxyChain.getMethodResult();
        });
    }

    public AbstractProxy createAdviceProxy(Class<? extends Annotation> annotation) {
        AbstractProxy abstractProxy = null;
        if (annotation == After.class) {
            abstractProxy = new AfterProxy();
        } else if (annotation == Before.class) {
            abstractProxy = new BeforeProxy();
        } else if (annotation == AfterReturning.class) {
            abstractProxy = new AfterReturningProxy();
        } else if (annotation == AfterThrowing.class) {
            abstractProxy = new AfterThrowingProxy();
        }
        return abstractProxy;
    }

}

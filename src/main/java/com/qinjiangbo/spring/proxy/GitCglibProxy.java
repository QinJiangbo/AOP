package com.qinjiangbo.spring.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @date: 24/12/2016 10:06 PM
 * @author: qinjiangbo@github.io
 */
public class GitCglibProxy implements MethodInterceptor {

    public <T> T getProxy(Class<T> clazz) {
        return (T) Enhancer.create(clazz, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        logBefore();
        Object result = methodProxy.invokeSuper(o, objects);
        logAfter();
        return result;
    }

    private void logBefore() {
        System.out.println(this.getClass().getName() + " @@@ "
                + "before fork() invoked!");
    }

    private void logAfter() {
        System.out.println(this.getClass().getName() + " @@@ "
                + "after fork() invoked!");
    }
}

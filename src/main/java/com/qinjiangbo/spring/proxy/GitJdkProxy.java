package com.qinjiangbo.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date: 22/12/2016 6:30 PM
 * @author: qinjiangbo@github.io
 */
public class GitJdkProxy implements InvocationHandler {

    private Object target;

    public GitJdkProxy(Object target) {
        this.target = target;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method,
                         Object[] args) throws Throwable {
        logBefore();
        Object result = method.invoke(target, args);
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

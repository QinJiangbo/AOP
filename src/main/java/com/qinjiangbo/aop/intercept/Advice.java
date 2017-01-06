package com.qinjiangbo.aop.intercept;

import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @date: 06/01/2017 10:09 AM
 * @author: qinjiangbo@github.io
 */
public interface Advice extends MethodInterceptor {

    public <T> T getProxy(Class<T> target);

    public default <T> T getProxy(T target) {
        return getProxy(target, null, null);
    }

    public <T> T getProxy(T target, Class[] args, Object[] argValues);
}

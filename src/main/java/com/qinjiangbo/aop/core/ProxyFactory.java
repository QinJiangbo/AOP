package com.qinjiangbo.aop.core;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import java.util.List;

/**
 * @date: 06/01/2017 12:29 PM
 * @author: qinjiangbo@github.io
 */
public class ProxyFactory {

    private Class<?> targetClass;
    private List<Proxy> proxyList;

    public ProxyFactory(Class<?> targetClass, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.proxyList = proxyList;
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

}

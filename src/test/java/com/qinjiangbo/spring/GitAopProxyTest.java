package com.qinjiangbo.spring;

import com.qinjiangbo.spring.proxy.GitAopProxy;
import com.qinjiangbo.spring.proxy.GitService;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @date: 25/12/2016 10:35 AM
 * @author: qinjiangbo@github.io
 */
public class GitAopProxyTest {

    @Test
    public void testFork() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GitService());
        proxyFactory.addAdvice(new GitAopProxy());
        Service service = (Service) proxyFactory.getProxy();
        service.fork("tomcat");
    }
}

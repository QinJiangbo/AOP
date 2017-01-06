package com.qinjiangbo.spring.proxy;

import org.junit.Test;

/**
 * @date: 22/12/2016 6:39 PM
 * @author: qinjiangbo@github.io
 */
public class GitJdkProxyTest {

    @Test
    public void testFork() {
        Service service = new GitJdkProxy(new GitService()).getProxy();
        service.fork("tomcat");
    }
}

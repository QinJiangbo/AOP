package com.qinjiangbo.spring.proxy;

import org.junit.Test;

/**
 * @date: 21/12/2016 2:33 PM
 * @author: qinjiangbo@github.io
 */
public class GitStaticProxyTest {

    @Test
    public void testFork() {
        Service service = new GitStaticProxy(new GitService());
        service.fork("tomcat");
    }
}

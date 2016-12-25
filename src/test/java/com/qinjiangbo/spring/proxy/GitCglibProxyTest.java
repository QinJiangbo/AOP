package com.qinjiangbo.spring.proxy;

import com.qinjiangbo.spring.proxy.GitCglibProxy;
import com.qinjiangbo.spring.proxy.GitService;
import com.qinjiangbo.spring.proxy.Service;
import org.junit.Test;

/**
 * @date: 24/12/2016 10:14 PM
 * @author: qinjiangbo@github.io
 */
public class GitCglibProxyTest {

    @Test
    public void testFork() {
        Service service = new GitCglibProxy().getProxy(GitService.class);
        service.fork("tomcat");
    }
}

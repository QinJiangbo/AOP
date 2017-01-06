package com.qinjiangbo.aop;

import com.qinjiangbo.aop.core.ProxyFactory;
import org.junit.Test;


/**
 * @date: 06/01/2017 5:08 PM
 * @author: qinjiangbo@github.io
 */
public class UserServiceProxyTest {

    @Test
    public void test() {
        UserServiceAspect aspect = new UserServiceAspect();
        ProxyFactory proxyFactory = new ProxyFactory(UserService.class, aspect);
        UserService userService = proxyFactory.createProxy();
        userService.login("Richard", "123456");
    }
}

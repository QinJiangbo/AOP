package com.qinjiangbo.aop.demo;

import com.qinjiangbo.aop.core.Proxy;
import com.qinjiangbo.aop.core.ProxyManager;

import java.util.LinkedList;
import java.util.List;

/**
 * @date: 06/01/2017 1:33 PM
 * @author: qinjiangbo@github.io
 */
public class UserServiceProxyTest {

    public static void main(String[] args) {
        List<Proxy> proxyList = new LinkedList<>();
        proxyList.add(new BeforeProxy());
        proxyList.add(new AfterProxy());

        ProxyManager proxyManager = new ProxyManager(UserService.class, proxyList);
        UserService userService = proxyManager.createProxy();
        userService.login("amy", "123456");
    }
}

package com.qinjiangbo.aop.demo;

import com.qinjiangbo.aop.annotation.After;
import com.qinjiangbo.aop.annotation.Before;

/**
 * @date: 06/01/2017 4:06 PM
 * @author: qinjiangbo@github.io
 */
public class UserServiceAspect {

    @Before("login")
    public void logBefore() {
        System.out.println("Before logging into system...");
    }

    @After("register")
    public void logAfter() {
        System.out.println("After registering into system...");
    }
}

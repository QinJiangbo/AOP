package com.qinjiangbo.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @date: 25/12/2016 11:41 AM
 * @author: qinjiangbo@github.io
 */
@Component
public class NamingService {

    public void rename(String name) {
        System.out.println("rename the name to " + name);
    }

    public boolean touch() {
        System.out.println("touch successfully!");
        return true;
    }

    public void welcome2017() {
        System.out.println("Welcome 2017!");
    }
}

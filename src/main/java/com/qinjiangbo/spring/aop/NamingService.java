package com.qinjiangbo.spring.aop;

/**
 * @date: 25/12/2016 11:41 AM
 * @author: qinjiangbo@github.io
 */
public class NamingService {

    public void rename(String name) {
        System.out.println("rename the name to " + name);
    }

    public boolean touch() {
        System.out.println("touch successfully!");
        return true;
    }
}

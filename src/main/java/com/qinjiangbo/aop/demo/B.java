package com.qinjiangbo.aop.demo;

import com.qinjiangbo.aop.annotation.Service;

/**
 * @date: 05/01/2017 1:31 PM
 * @author: qinjiangbo@github.io
 */
@Service
public class B {

    private String name;

    public B(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "I am B, my name is " + this.name;
    }
}

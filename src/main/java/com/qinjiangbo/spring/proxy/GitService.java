package com.qinjiangbo.spring.proxy;

/**
 * @date: 21/12/2016 2:11 PM
 * @author: qinjiangbo@github.io
 */
public class GitService implements Service {

    @Override
    public void fork(String repository) {
        System.out.println("fork " + repository + " successfully!");
    }
}
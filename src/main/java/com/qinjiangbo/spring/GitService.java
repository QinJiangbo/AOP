package com.qinjiangbo.spring;

/**
 * @date: 21/12/2016 2:11 PM
 * @author: qinjiangbo@github.io
 */
public class GitService implements Service {

    /**
     * 拷贝某个仓库
     *
     * @param repository
     */
    @Override
    public void fork(String repository) {
        System.out.println("fork " + repository + " successfully!");
    }

}

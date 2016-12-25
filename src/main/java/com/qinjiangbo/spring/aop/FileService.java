package com.qinjiangbo.spring.aop;

/**
 * @date: 25/12/2016 11:22 AM
 * @author: qinjiangbo@github.io
 */
public class FileService {

    public boolean copy(String src, String dest) {
        System.out.println("copy " + src + " to " + dest + " successfully!");
        return true;
    }

    public boolean delete(String fileName) {
        System.out.println("delete " + fileName + " successfully!");
        return true;
    }

    public void welcome() {
        System.out.println("welcome to spring aop!");
    }

}

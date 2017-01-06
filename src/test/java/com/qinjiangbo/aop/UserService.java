package com.qinjiangbo.aop;

/**
 * @date: 06/01/2017 1:26 PM
 * @author: qinjiangbo@github.io
 */
public class UserService {

    public boolean login(String userName, String password) {
        System.out.println("username[" + userName + "] " +
                "and password[" + password + "] are correct!");
        return true;
    }

    public void register(String userName) {
        System.out.println("register " + userName + "!");
    }

}

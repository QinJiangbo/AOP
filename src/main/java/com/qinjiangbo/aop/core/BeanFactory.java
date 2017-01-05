package com.qinjiangbo.aop.core;

import java.util.LinkedList;
import java.util.List;

/**
 * @date: 03/01/2017 11:34 AM
 * @author: qinjiangbo@github.io
 */
public class BeanFactory {

    private static BeanFactory INSTANCE = null;
    private List<Class<?>> classList = new LinkedList<>();

    private BeanFactory() {
    }

    /**
     * get the singleton instances
     *
     * @return
     */
    public static BeanFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (BeanFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BeanFactory();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * add scanned classes
     */
    public void addClasses(List<Class<?>> classList) {
        this.classList.addAll(classList);
    }

}

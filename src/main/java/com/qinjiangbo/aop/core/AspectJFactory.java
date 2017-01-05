package com.qinjiangbo.aop.core;

import java.util.List;

/**
 * @date: 05/01/2017 6:08 PM
 * @author: qinjiangbo@github.io
 */
public class AspectJFactory {
    private BeanFactory beanFactory;
    private static AspectJFactory INSTANCE = null;

    private AspectJFactory() {
        beanFactory = BeanFactory.getInstance();
    }

    public static AspectJFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (AspectJFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AspectJFactory();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * filter the AspectJ classes
     *
     * @return
     */
    private List<Class<?>> filterAspectJs() {
        // invoke beanFactory's method
        return beanFactory.filterAspectJs();
    }

}

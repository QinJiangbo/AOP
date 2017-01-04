package com.qinjiangbo.aop.core;

import com.qinjiangbo.aop.config.ContextConfig;

/**
 * @date: 04/01/2017 10:14 PM
 * @author: qinjiangbo@github.io
 */
public class ApplicationContext {

    private ContextConfig contextConfig;
    private BeanFactory beanFactory;

    public ApplicationContext(ContextConfig contextConfig) {
        this.contextConfig = contextConfig;
    }

    private void scanPackages() {

    }
}

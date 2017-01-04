package com.qinjiangbo.aop.core;

import com.qinjiangbo.aop.config.ContextConfig;

import java.util.List;

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

    /**
     * scan the specified packages
     */
    private void scanPackages() {
        List<String> packages = contextConfig.getPackages();
        for (String package0 : packages) {

        }
    }
}

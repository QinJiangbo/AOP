package com.qinjiangbo.aop.core;

import com.qinjiangbo.aop.annotation.Bean;
import com.qinjiangbo.aop.config.ContextConfig;
import com.qinjiangbo.aop.util.PackageUtils;

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
        beanFactory = BeanFactory.getInstance();
    }

    /**
     * scan the specified packages
     */
    private void scanPackages() {
        List<String> packages = contextConfig.getPackages();
        for (String package0 : packages) {
            beanFactory.addClasses(PackageUtils.findClassList(package0, true, Bean.class));
        }
    }

    public <T> T getBean(String name, Class<T> clazz) {
        return null;
    }
}

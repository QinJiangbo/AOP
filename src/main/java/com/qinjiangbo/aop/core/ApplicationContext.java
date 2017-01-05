package com.qinjiangbo.aop.core;

import com.qinjiangbo.aop.annotation.Service;
import com.qinjiangbo.aop.config.ContextConfig;
import com.qinjiangbo.aop.demo.A;
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
        // scan packages
        scanPackages();
    }

    /**
     * scan the specified packages
     */
    private void scanPackages() {
        List<String> packages = contextConfig.getPackages();
        for (String package0 : packages) {
            beanFactory.addClasses(PackageUtils.findClassList(package0, true, Service.class));
        }
        beanFactory.mapClasses();
        beanFactory.clearClassList();
    }

    /**
     * get bean by name and type, but the bean is processed
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getBean(String name, Class<T> clazz) {
        System.out.println(beanFactory.getBean(name));
        return null;
    }

    public static void main(String[] args) {
        ContextConfig config = new ContextConfig();
        config.setPackages("com.qinjiangbo.aop.demo;com.qinjiangbo.aop.demo2");
        ApplicationContext applicationContext = new ApplicationContext(config);
        applicationContext.getBean("b", A.class);
    }
}

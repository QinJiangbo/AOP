package com.qinjiangbo.aop.core;

import com.qinjiangbo.aop.annotation.Service;
import com.qinjiangbo.aop.config.ContextConfiguration;
import com.qinjiangbo.aop.core.factory.BeanFactory;
import com.qinjiangbo.aop.demo.A;
import com.qinjiangbo.aop.demo.B;
import com.qinjiangbo.aop.util.BeanUtils;
import com.qinjiangbo.aop.util.PackageUtils;

import java.util.List;

/**
 * @date: 04/01/2017 10:14 PM
 * @author: qinjiangbo@github.io
 */
public class ApplicationContext {

    private ContextConfiguration contextConfig;
    private BeanFactory beanFactory;

    public ApplicationContext(ContextConfiguration contextConfig) {
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
        Class<?> clazz0 = beanFactory.getBean(name);
        return BeanUtils.getBean(name, clazz0, clazz);
    }

    /**
     * get bean by name and type if parameters provided
     *
     * @param name
     * @param clazz
     * @param args
     * @param <T>
     * @return
     */
    public <T> T getBean(String name, Class<T> clazz, Object... args) {
        Class<?> clazz0 = beanFactory.getBean(name);
        return BeanUtils.getBean(name, clazz0, clazz, args);
    }

    public static void main(String[] args) {
        ContextConfiguration config = new ContextConfiguration();
        config.setPackages("com.qinjiangbo.aop.demo;com.qinjiangbo.aop.demo2");
        ApplicationContext applicationContext = new ApplicationContext(config);
        A a = applicationContext.getBean("a", A.class);
        System.out.println(a.toString());
        B b = applicationContext.getBean("b", B.class, "Amy");
        System.out.println(b.toString());
    }
}

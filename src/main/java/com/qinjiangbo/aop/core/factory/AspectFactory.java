package com.qinjiangbo.aop.core.factory;

import com.qinjiangbo.aop.annotation.After;
import com.qinjiangbo.aop.annotation.Around;
import com.qinjiangbo.aop.annotation.Before;
import com.qinjiangbo.aop.util.AnnotationUtils;
import com.qinjiangbo.aop.util.CollectionUtils;
import com.qinjiangbo.aop.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @date: 05/01/2017 6:08 PM
 * @author: qinjiangbo@github.io
 */
public class AspectFactory {
    private BeanFactory beanFactory;
    private static AspectFactory INSTANCE = null;
    private List<Class<?>> aspectjs;

    private AspectFactory() {
        beanFactory = BeanFactory.getInstance();
        aspectjs = beanFactory.filterAspectJs();
    }

    public static AspectFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (AspectFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AspectFactory();
                }
            }
        }
        return INSTANCE;
    }

    public void processAdvices() {

    }

    /**
     * parse annotations in Aspect class
     * @param clazz
     */
    private void processAspectJAdvice(Class<?> clazz) {
        List<Method> methodList = ReflectionUtils.findAnnotatedMethods(clazz);
        List<Class<? extends Annotation>> annotations
                = CollectionUtils.newLinkedList(After.class, Around.class, Before.class);
        methodList = AnnotationUtils.filterAnnotatedMethods(methodList, annotations);
        // TO-DO
    }

    /**
     * parse intercept expression starting with "@"
     * eg.<code>
     *
     * @Before("@SysLog")
     * public void logBefore(){
     * ....
     * }
     * </code>
     */
    private void parseAnnotatedAdviceExpression() {
        // TO-DO
    }

    /**
     * parse intercept expression with executions
     * eg.<code>
     *
     * @Before("com.qinjiangbo.aop.demo.*")
     * public void logBefore() {
     * ...
     * }
     * </code>
     */
    private void parseExecutedAdviceExpression() {
        // TO-DO
    }

}

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
public class AspectJFactory {
    private BeanFactory beanFactory;
    private static AspectJFactory INSTANCE = null;
    private List<Class<?>> aspectjs;

    private AspectJFactory() {
        beanFactory = BeanFactory.getInstance();
        aspectjs = beanFactory.filterAspectJs();
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

    public void processAdvices() {

    }

    /**
     * parse annotations in AspectJ class
     * @param clazz
     */
    private void processAspectJAdvice(Class<?> clazz) {
        List<Method> methodList = ReflectionUtils.findAnnotatedMethods(clazz);
        List<Class<? extends Annotation>> annotations
                = CollectionUtils.newLinkedList(After.class, Around.class, Before.class);
        methodList = AnnotationUtils.filterAnnotatedMethods(methodList, annotations);

    }

    /**
     * parse advice expression starting with "@"
     * eg.<code>
     *
     * @Before("@SysLog")
     * public void logBefore(){
     * ....
     * }
     * </code>
     */
    private void parseAnnotatedAdviceExpression() {

    }

    /**
     * parse advice expression with executions
     * eg.<code>
     *
     * @Before("com.qinjiangbo.aop.demo.*")
     * public void logBefore() {
     * ...
     * }
     * </code>
     */
    private void parseExecutedAdviceExpression() {

    }

}

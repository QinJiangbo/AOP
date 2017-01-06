package com.qinjiangbo.aop.util;

import com.qinjiangbo.aop.annotation.After;
import com.qinjiangbo.aop.annotation.AfterReturning;
import com.qinjiangbo.aop.annotation.AfterThrowing;
import com.qinjiangbo.aop.annotation.Before;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * @date: 06/01/2017 4:11 PM
 * @author: qinjiangbo@github.io
 */
public class ReflectionUtils {

    public static List<Method> findAnnotatedMethods(Class<?> clazz, List<Class<? extends Annotation>> annotations) {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> methodList = new LinkedList<>();
        for (Method method : methods) {
            for (Class<? extends Annotation> annotation : annotations) {
                if (method.isAnnotationPresent(annotation)) {
                    methodList.add(method);
                    break;
                }
            }
        }
        return methodList;
    }

    public static Class<? extends Annotation> findMethodAnnotation(Method method) {
        List<Class<? extends Annotation>> annotations = CollectionUtils.newLinkedList(
                Before.class, After.class, AfterReturning.class, AfterThrowing.class
        );
        Class<? extends Annotation> annotation0 = null;
        for (Class<? extends Annotation> annotation : annotations) {
            if (method.isAnnotationPresent(annotation)) {
                annotation0 = annotation;
                break;
            }
        }
        return annotation0;
    }
}

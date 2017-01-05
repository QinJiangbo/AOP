package com.qinjiangbo.aop.core;

import com.qinjiangbo.aop.exception.ConflictedBeanException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @date: 03/01/2017 11:34 AM
 * @author: qinjiangbo@github.io
 */
public class BeanFactory {

    private static BeanFactory INSTANCE = null;
    private List<Class<?>> classList = new LinkedList<>();
    private Map<String, Class<?>> classMap = new HashMap<>();

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
        mapClasses();
    }

    /**
     * map the classes
     */
    private void mapClasses() {
        for (Class<?> clazz : classList) {
            String className = clazz.getSimpleName().substring(0, 1).toLowerCase()
                    + clazz.getSimpleName().substring(1);
            if (classMap.containsKey(className)) {
                throw new ConflictedBeanException(className + " for class " + clazz.getName()
                        + " already exists!");
            }
            classMap.put(className, clazz);
        }
        // release the resource, waiting for GC
        classList = null;
    }

}

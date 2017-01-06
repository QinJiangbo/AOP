package com.qinjiangbo.aop.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @date: 06/01/2017 3:57 PM
 * @author: qinjiangbo@github.io
 */
public class AspectCut {

    private Method method;
    private Object aspectTarget;
    private Object[] args;

    public AspectCut(Method method, Object aspectTarget, Object[] args) {
        this.method = method;
        this.aspectTarget = aspectTarget;
        this.args = args;
    }

    /**
     * invoke the logic of aspect class
     *
     * @return
     */
    public Object proceed() {
        Object retVal = null;
        try {
            retVal = method.invoke(aspectTarget, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public Method getMethod() {
        return method;
    }

    public Object getAspectTarget() {
        return aspectTarget;
    }

    public Object[] getArgs() {
        return args;
    }
}

package com.qinjiangbo.aop.annotation;

import java.lang.annotation.*;

/**
 * @date: 06/01/2017 3:40 PM
 * @author: qinjiangbo@github.io
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AfterThrowing {
    String value() default "";
}

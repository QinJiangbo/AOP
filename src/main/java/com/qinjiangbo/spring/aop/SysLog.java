package com.qinjiangbo.spring.aop;

import java.lang.annotation.*;

/**
 * @date: 26/12/2016 8:55 PM
 * @author: qinjiangbo@github.io
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SysLog {

}

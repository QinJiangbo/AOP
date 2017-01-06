package com.qinjiangbo.aop.util;

import java.util.LinkedList;
import java.util.List;

/**
 * @date: 06/01/2017 4:43 PM
 * @author: qinjiangbo@github.io
 */
public class CollectionUtils {

    public static <T> List<T> newLinkedList(T... args) {
        List<T> list = new LinkedList<>();
        for (T t : args) {
            list.add(t);
        }
        return list;
    }
}

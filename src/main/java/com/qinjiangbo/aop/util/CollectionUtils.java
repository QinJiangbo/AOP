package com.qinjiangbo.aop.util;

import java.util.LinkedList;
import java.util.List;

/**
 * @date: 05/01/2017 11:30 AM
 * @author: qinjiangbo@github.io
 */
public class CollectionUtils {

    /**
     * create a linked list with parameters
     *
     * @param args
     * @param <T>
     * @return
     */
    public static <T> List<T> newLinkedList(T... args) {
        List<T> list = new LinkedList<T>();
        for (T t : args) {
            list.add(t);
        }
        return list;
    }
}

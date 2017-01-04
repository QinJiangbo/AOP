package com.qinjiangbo.aop.util;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * @date: 04/01/2017 11:12 PM
 * @author: qinjiangbo@github.io
 */
public class PackageUtils {

    /**
     * find the class list in the package
     *
     * @param packageName
     * @param recursive   if true, traverse recursively to find all class files
     * @param annotation  filter the class by annotation
     * @return
     */
    public static List<Class<?>> findClassList(String packageName, boolean recursive, Class<? extends Annotation> annotation) {
        List<Class<?>> classList = new LinkedList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String packagePath = packageName.replace(".", "/");
        try {
            Enumeration<URL> urls = classLoader.getResources(packagePath);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    String protocol = url.getProtocol();
                    String path = url.getPath();
//                    System.out.println("protocol: " + protocol + "<-->path: " + path);
                    if ("file".equals(protocol)) {

                    } else if ("jar".equals(protocol)) {

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classList;
    }

    /**
     * find the class list of current project
     *
     * @param classList
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param annotation
     */
    private static void findClassName(List<Class<?>> classList, String packageName, String packagePath, boolean recursive, Class<? extends Annotation> annotation) {

    }

    /**
     * find the class list of third-party jar file
     *
     * @param classList
     * @param packageName
     * @param url
     * @param recursive
     * @param annotation
     */
    private static void findClassName(List<Class<?>> classList, String packageName, URL url, boolean recursive, Class<? extends Annotation> annotation) {

    }

    public static void main(String[] args) {
        findClassList("org.springframework.context", true, null);
    }
}

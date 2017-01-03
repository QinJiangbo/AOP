package com.qinjiangbo.aop.config;

import java.util.LinkedList;
import java.util.List;

/**
 * @date: 03/01/2017 3:21 PM
 * @author: qinjiangbo@github.io
 */
public class AopConfiguration {

    // packages to be scanned
    private List<String> scanPackages;

    /**
     * get scan packages path
     *
     * @return
     */
    public List<String> getScanPackages() {
        return scanPackages;
    }

    /**
     * set the packages to be scanned
     *
     * @param scanPackages
     */
    public void setScanPackages(String scanPackages) {
        String[] packages = scanPackages.split(",");
        this.scanPackages = new LinkedList<>();
        for (String packagge : packages) {
            if (!this.scanPackages.contains(packagge)) {
                this.scanPackages.add(packagge);
            }
        }
    }
}

package com.qinjiangbo.spring.aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date: 25/12/2016 11:55 AM
 * @author: qinjiangbo@github.io
 */
public class FileServiceAspectTest {

    private ApplicationContext applicationContext = null;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
    }

    @Test
    public void testCopy() {
        FileService fileService = (FileService) applicationContext.getBean("fileService");
        fileService.copy("/Richard/home", "/root/home");
    }

    @Test
    public void testDelete() {
        FileService fileService = (FileService) applicationContext.getBean("fileService");
        fileService.delete("birthday");
    }

    @Test
    public void testWelcome() {
        FileService fileService = (FileService) applicationContext.getBean("fileService");
        fileService.welcome();
    }

}

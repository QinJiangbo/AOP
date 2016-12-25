package com.qinjiangbo.spring.proxy;

/**
 * @date: 21/12/2016 2:22 PM
 * @author: qinjiangbo@github.io
 */
public class GitStaticProxy implements Service {

    private GitService gitService;

    public GitStaticProxy(GitService gitService) {
        this.gitService = gitService;
    }

    @Override
    public void fork(String repository) {
        logBefore();
        gitService.fork(repository);
        logAfter();
    }

    /**
     * 记录方法执行前日志
     */
    private void logBefore() {
        System.out.println(this.getClass().getName() + " >>> " + "before fork() invoked!");
    }

    /**
     * 记录方法后日志
     */
    private void logAfter() {
        System.out.println(this.getClass().getName() + " >>> " + "after fork() invoked!");
    }

}

package com.blog.aop;

import com.blog.entity.Blog;
import com.blog.service.ResBlogService;
import com.rss.RssAction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Aspect
@Component
public class RefreshRssAspect {
    @Resource
    private ResBlogService resBlogService;

    /**
     * 定义一个方法，用于声明切入点表达式，方法中一般不需要添加其他代码
     * 使用@Pointcut声明切入点表达式
     * 后面的通知直接使用方法名来引用当前的切点表达式；如果是其他类使用，加上包名即可
     */
    @Pointcut("@annotation(com.blog.aop.RefreshRssAnnotation)")
    public void refreshRss(){}

    /**
     * 后置通知（无论方法是否发生异常都会执行,所以访问不到方法的返回值）
     * @param joinPoint
     */
    @After("refreshRss()")
    public void afterMethod(JoinPoint joinPoint){
        String path="D:\\wonderful\\Blog\\src\\main\\webapp";
        RssAction rss=new RssAction();
        List<Blog> blogs = resBlogService.selectAll();
        rss.testBuildObject(blogs, null, path);
    }
}
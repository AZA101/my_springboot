package com.imooc.demo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author YJB
 * 2019-06-15
 */
@Aspect
@Component  //把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
public class HttpAspect {
    //使用slf4j这个日志类
    private final static Logger logger=LoggerFactory.getLogger(HttpAspect.class);
    //表达式的主体；括号表示参数，两个点表示任何参数类型
    @Pointcut("execution(public * com.imooc.demo.Controller.GirlController.girlAdd(..) )")
    public void log(){

    }
    @Before("log()")
    //获取类名和类方法的时候必须使用到该参数,JoinPoint对象封装了SpringAop中切面方法的信息,
    public  void doBefore(JoinPoint joinPoint){
        //System.out.println("开始之前插入aop对象");
        //logger.info("使用日志类在开始之前插入aop对象");
        //RequestContextHolder持有Request上下文容器
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest  request=attributes.getRequest();
        //url
         logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public  void doAfter(){
        //System.out.println("结束之后插入aop对象");
        logger.info("使用日志类在开始之后插入aop对象");
    }
    //将之前请求方法返回的数据进行接收并显示出来在控制台上 这个主要和java类中与数据库表形成一一对应的Java类进行关联
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doReturning(Object object){
        logger.info("response={}",object.toString());
    }

}


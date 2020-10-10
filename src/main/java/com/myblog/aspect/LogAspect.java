package com.myblog.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect    //定义切面 使用@Aspect 注解的类， Spring 将会把它当作一个特殊的Bean（一个切面），也就是不对这个类本身进行动态代理
@Component //添加到组件
public class LogAspect {

    //获得日志对象
    private Logger log = LoggerFactory.getLogger(this.getClass());


    //这个就是说在这个包com.myblog.controller下面发生的任何事情都会被切面织入

    //定义切点 和切点表达式 表示任意返回值 这个包下面的任意类下面的任意方法和方法下面是任意参数
    @Pointcut("execution(* com.myblog.controller.*.*(..))")
    public void log(){}

    //下面引入切点
    @Before("log()")   //注意导入的包
    public void before(JoinPoint joinPoint){
        //在这个方法开始前应该做什么事
        //我们需要他帮我们记录是什么路径地址调用了什么方法得到了什么结果参数是什么
        //所以我们将这这些信息封装成一个对象,然后获取并且输出  这个类就是RequestLog
        //接下来就是获取这个对象，然后封装起来
        //1.获取HttpServletRequest对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String url =request.getRequestURL().toString();//获得访问路径
        String ip = request.getRemoteAddr();//获得访问ip
        //获得类名.方法名
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        //获得方法参数
        Object[] args = joinPoint.getArgs();

        RequestLog requestLog = new RequestLog(url,ip, classMethod,args);
        //打印请求信息
        log.info("Request: {}", requestLog);
    }

    //around和AfterReturning的配置区别如下，
    // 注意AfterReturning配置必须有argNames参数，且参数值和returning开麦你的值一样，这样在织入代码里面便可通过returning的值获取被织入函数的返回值。


    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result){

        //打印返回值
        log.info("Result: {}", result);
    }

}

package com.example.demo.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.acl.LastOwnerException;
import java.util.Arrays;
/**
 * web请求日志切面类---专门针对控制层，如谁被请求了，花了多少时间，请求发送的参数，返回得值等
 * @author yy
 */
@Aspect     // 表示一个切面bean
@Component  // bean容器的组件注解。虽然放在contrller包里，但它不是控制器。如果注入service,但我们又没有放在service包里
@Order(3)   // 有多个日志时，ORDER可以定义切面的执行顺序（数字越大，前置越后执行，后置越前执行）
public class WebLogAspect {
    //定义一个日志记录器
    Logger logger=LoggerFactory.getLogger(this.getClass());
    //定义一个线程本地变量，记录各个线程开始的时间
    ThreadLocal<Long> starttime=new ThreadLocal<Long>();

    /**
     * 定义一个切入点
     */
    @Pointcut("execution(public * com.*.*.controller.*.*(..))")
    public void weblog(){
    }
    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("前置通知");
        starttime.set(System.currentTimeMillis());

        //获取servlet请求对象---因为这不是控制器，这里不能注入HttpServletRequest，但springMVC本身提供ServletRequestAttributes可以拿到
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("URL:"+request.getRequestURL().toString());
        logger.info("Method:"+request.getMethod());
        logger.info("CLASS_METHOD:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("ARGS:"+ Arrays.toString(joinPoint.getArgs()));
        LogRecord.writeLog(joinPoint.getTarget());
    }
    //方法的返回值注入ret
    @AfterReturning(returning = "ret",pointcut = "weblog()")
    public void doafter(Object ret) {
        logger.info("后置通知：");
        logger.info("RESPONSE:" + ret);       // 响应的内容---方法的返回值responseEntity
        logger.info("SPEND:" + (System.currentTimeMillis() - starttime.get()));

        System.out.println(ret);
    }
}

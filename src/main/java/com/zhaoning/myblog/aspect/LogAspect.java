package com.zhaoning.myblog.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author zhaoning
 * @date 2020/5/3 - 12:47
 */
@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


//    @Pointcut定义切面，里面的参数指定拦截什么
    @Pointcut("execution(* com.zhaoning.myblog.web.*.*(..))")
    public void log(){}

//    在方法返回之前执行
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
//        拿到request对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
//        获取请求url
        String url = request.getRequestURI();
//        获取请求ip
        String ip = request.getRemoteAddr();
//        获取请求的那个方法
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
//        获取请求参数
        Object[] args = joinPoint.getArgs();

        RequestLog requestLog = new RequestLog(url,ip,classMethod,args);

        logger.info("Request : {}", requestLog );

    }

//    在方法返回之后接着执行
    @After("log()")
    public void doAfter(){
//        logger.info("--------------doAfter--------------");
    }


//    在方法返回之后执行
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){

        logger.info("Result : {}" ,result);
    }

    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }

}

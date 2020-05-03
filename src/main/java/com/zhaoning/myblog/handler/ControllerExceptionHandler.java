package com.zhaoning.myblog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhaoning
 * @date 2020/5/3 - 10:26
 */
//拦截有controller注解的控制器
@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());


//    标识这个方法是做异常处理的，加上才有效
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) throws Exception {
        //记录到日志
        logger.error("Request URL : {},Exception: {}",request.getRequestURI(),e);
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null){
            throw e;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURI());
        mv.addObject("exception",e);
        //返回页面
        mv.setViewName("error/error");
        return mv;
    }
}

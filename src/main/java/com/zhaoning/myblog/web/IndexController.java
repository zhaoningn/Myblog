package com.zhaoning.myblog.web;

import com.zhaoning.myblog.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author zhaoning
 * @date 2020/5/3 - 10:16
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}

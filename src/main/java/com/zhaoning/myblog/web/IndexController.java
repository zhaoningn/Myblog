package com.zhaoning.myblog.web;

import com.zhaoning.myblog.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhaoning
 * @date 2020/5/3 - 10:16
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
//        int i = 9/0;
        String blog = null;
        if (blog == null){
            throw new NotFoundException("博客不存在");
        }

        return "index";
    }
}

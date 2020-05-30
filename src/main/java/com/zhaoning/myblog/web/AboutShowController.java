package com.zhaoning.myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhaoning
 * @date 2020/5/10 - 17:47
 */
@Controller
public class AboutShowController {

    @GetMapping("/about")
    public String aboutMe(){
        return "about";
    }
}

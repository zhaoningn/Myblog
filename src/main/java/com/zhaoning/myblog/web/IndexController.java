package com.zhaoning.myblog.web;

import com.zhaoning.myblog.exception.NotFoundException;
import com.zhaoning.myblog.service.BlogService;
import com.zhaoning.myblog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author zhaoning
 * @date 2020/5/3 - 10:16
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 2,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                        Model model){

//        model.addAttribute("page",blogService.listBlog());



        return "index";
    }
}

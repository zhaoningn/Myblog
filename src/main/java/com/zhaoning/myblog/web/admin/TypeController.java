package com.zhaoning.myblog.web.admin;

import com.zhaoning.myblog.po.Type;
import com.zhaoning.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author zhaoning
 * @date 2020/5/4 - 10:06
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

//    分类管理页
    @GetMapping("/types")
    public String types(@PageableDefault(size = 4,sort = {"id"},direction = Sort.Direction.DESC)
                                    Pageable pageable, Model model){

        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }


//    调到增加分类的页面
    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/type-input";
    }

//    编辑分类
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id,Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/type-input";

    }
//    删除分类
    @GetMapping("/types/{id}/delete")
    public String deleteByid(@PathVariable Long id){
        typeService.deleteType(id);
        return "redirect:/admin/types";
    }



//    增加分类
    @PostMapping("/types")
    public String post(@Valid Type type,BindingResult result, RedirectAttributes redirectAttributes){

        Type type2 = typeService.getTypeByName(type.getName());

        if (type2!=null){
            result.rejectValue("name","nameError","已有该分类");
        }
        if (result.hasErrors()){
            return "admin/type-input";
        }

        Type type1 = typeService.saveType(type);

        if (type1 == null){
            redirectAttributes.addFlashAttribute("message","新增失败");
        }else {
            redirectAttributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type,BindingResult result,@PathVariable Long id, RedirectAttributes redirectAttributes){

        Type type2 = typeService.getTypeByName(type.getName());

        if (type2!=null){
            result.rejectValue("name","nameError","已有该分类");
        }

        if (result.hasErrors()){
            return "admin/type-input";
        }

        Type type1 = typeService.updateType(id,type);

        if (type1 == null){
            redirectAttributes.addFlashAttribute("message","更新失败");
        }else {
            redirectAttributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/types";
    }



}

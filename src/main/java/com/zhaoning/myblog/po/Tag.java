package com.zhaoning.myblog.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoning
 * @date 2020/5/3 - 16:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_tag")
public class Tag {

    @Id
    @GeneratedValue
    private Long id;


    @NotBlank(message = "标签名称不能为空")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();

}

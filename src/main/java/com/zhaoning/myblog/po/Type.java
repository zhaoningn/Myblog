package com.zhaoning.myblog.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoning
 * @date 2020/5/3 - 16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();

}

package com.zhaoning.myblog.dao;

import com.zhaoning.myblog.po.Tag;
import com.zhaoning.myblog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhaoning
 * @date 2020/5/4 - 17:40
 */
public interface TagRepository extends JpaRepository<Tag,Long>{
    Tag findByName(String name);
}

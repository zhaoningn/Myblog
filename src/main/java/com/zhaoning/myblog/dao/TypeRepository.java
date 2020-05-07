package com.zhaoning.myblog.dao;

import com.zhaoning.myblog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhaoning
 * @date 2020/5/4 - 9:57
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

}

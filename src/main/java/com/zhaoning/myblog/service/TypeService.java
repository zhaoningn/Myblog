package com.zhaoning.myblog.service;

import com.zhaoning.myblog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author zhaoning
 * @date 2020/5/4 - 9:53
 */
public interface TypeService {
//    新增
    Type saveType(Type type);
//    查询
    Type getType(Long id);

    Page<Type> listType(Pageable pageable);
//    修改
    Type updateType(Long id,Type type);
//    删除
    void deleteType(Long id);

    Type getTypeByName(String name);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

}

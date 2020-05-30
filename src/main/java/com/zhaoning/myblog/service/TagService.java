package com.zhaoning.myblog.service;

import com.zhaoning.myblog.po.Tag;
import com.zhaoning.myblog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author zhaoning
 * @date 2020/5/4 - 17:37
 */
public interface TagService {

    Page<Tag> listTag(Pageable pageable);

    Tag getTagByName(String name);

    Tag saveTag(Tag tag);

    Tag updateTag(Long id,Tag tag);

    Tag getTag(Long id);

    void deleteTag(Long id);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);
}

package com.myblog.dao;

import com.myblog.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {
    List<Tag> getAllTag();

    int saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> getBlogTag();

    int updateTag(Tag tag);

    int deleteTag(Long id);
}

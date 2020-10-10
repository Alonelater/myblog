package com.myblog.dao;

import com.myblog.pojo.Blog;
import com.myblog.pojo.BlogAndTag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {
    List<Blog> getAllBlog();

    List<Blog> searchAllBlog(Blog blog);

    void saveBlog(Blog blog);

    void saveBlogAndTag(BlogAndTag blogAndTag);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

    Blog getBlog(Long id);

    Blog getDetailedBlog(Long id);

    List<Blog> getByTypeId(Long typeId);

    List<Blog> getByTagId(Long tagId);

    List<Blog> getIndexBlog();

    List<Blog> getAllRecommendBlog();

    List<Blog> getSearchBlog(String query);

    List<String> findGroupYear();

    List<Blog> findByYear(String year);
}

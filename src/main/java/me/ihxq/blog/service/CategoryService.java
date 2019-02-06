package me.ihxq.blog.service;

import me.ihxq.blog.pojo.entity.CategoryDO;

/**
 * @author xq.h
 * on 2019-02-07 00:43
 **/
public interface CategoryService {
    CategoryDO findById(Long categoryId);
}

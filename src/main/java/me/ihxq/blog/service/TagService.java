package me.ihxq.blog.service;

import me.ihxq.blog.pojo.entity.TagDO;

/**
 * @author xq.h
 * on 2019-02-07 00:46
 **/
public interface TagService {

    TagDO findById(Long tagId);
}

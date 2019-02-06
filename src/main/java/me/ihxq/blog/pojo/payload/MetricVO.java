package me.ihxq.blog.pojo.payload;

import lombok.Data;


/**
 * @author xq.h
 * 2019-02-07 01:23
 **/
@Data
public class MetricVO {
    private Long id;

    private long likes;
    private long dislikes;
    private long pv;

    private long articleId;
}

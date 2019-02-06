package me.ihxq.blog.service;

import me.ihxq.blog.pojo.entity.MetricDO;
import me.ihxq.blog.pojo.payload.MetricVO;

import java.util.Optional;

/**
 * @author xq.h
 * 2019-02-07 01:39
 **/
public interface MetricService {
    void like(long articleId);

    void dislike(long articleId);

    void increasePV(long articleId);

    MetricDO createMetric(long articleId);

    MetricDO findById(long articleId);

    MetricVO convert(MetricDO metricDO);
}

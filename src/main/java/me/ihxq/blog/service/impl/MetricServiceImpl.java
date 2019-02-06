package me.ihxq.blog.service.impl;

import me.ihxq.blog.exception.RequestUnacceptableException;
import me.ihxq.blog.pojo.entity.ArticleDO;
import me.ihxq.blog.pojo.entity.MetricDO;
import me.ihxq.blog.pojo.payload.MetricVO;
import me.ihxq.blog.repository.MetricRepository;
import me.ihxq.blog.service.ArticleService;
import me.ihxq.blog.service.MetricService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xq.h
 * 2019-02-07 01:42
 **/
@Service
public class MetricServiceImpl implements MetricService {

    @Resource
    private MetricRepository metricRepository;

    @Resource
    private ArticleService articleService;

    @Override
    public void like(long articleId) {
        MetricDO metric = metricRepository.findByArticle(new ArticleDO(articleId)).orElseGet(() -> this.createMetric(articleId));
        metric.setLikes(metric.getLikes() + 1);
        metricRepository.save(metric);
    }

    @Override
    public void dislike(long articleId) {
        MetricDO metric = metricRepository.findByArticle(new ArticleDO(articleId)).orElseGet(() -> this.createMetric(articleId));
        metric.setDislikes(metric.getDislikes() + 1);
        metricRepository.save(metric);
    }

    @Override
    public void increasePV(long articleId) {
        MetricDO metric = metricRepository.findByArticle(new ArticleDO(articleId)).orElseGet(() -> this.createMetric(articleId));
        metric.setPv(metric.getPv() + 1);
        metricRepository.save(metric);
    }

    @Override
    public MetricDO createMetric(long articleId) {
        ArticleDO article = articleService.findById(articleId).orElseThrow(() -> new RequestUnacceptableException("No metric found!"));
        MetricDO metricDO = new MetricDO();
        metricDO.setArticle(article);
        return metricDO;
    }

    @Override
    public MetricDO findById(long articleId) {
        return metricRepository.findByArticle(new ArticleDO(articleId)).orElseGet(() -> {
            MetricDO metric = this.createMetric(articleId);
            metricRepository.save(metric);
            return metric;
        });
    }
}

package me.ihxq.blog.controller;

import me.ihxq.blog.service.DomainConvertService;
import me.ihxq.blog.pojo.entity.MetricDO;
import me.ihxq.blog.pojo.payload.MetricVO;
import me.ihxq.blog.pojo.payload.Result;
import me.ihxq.blog.service.MetricService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xq.h
 * 2019-02-06 19:10
 **/
@RestController
@RequestMapping("metric")
public class MetricController {

    @Resource
    private DomainConvertService domainConvertService;

    @Resource
    private MetricService metricService;

    @PutMapping("like/{id}")
    public Result like(@PathVariable Long id) {
        metricService.like(id);
        return new Result();
    }

    @PutMapping("dislike/{id}")
    public Result dislike(@PathVariable Long id) {
        metricService.dislike(id);
        return new Result();
    }

    @GetMapping("{articleId}")
    public Result<MetricVO> findById(@PathVariable long articleId) {
        MetricDO find = metricService.findById(articleId);
        MetricVO convert = domainConvertService.convert(find, MetricVO.class);
        return new Result<>(convert);
    }

}

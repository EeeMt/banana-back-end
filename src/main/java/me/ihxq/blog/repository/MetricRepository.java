package me.ihxq.blog.repository;

import me.ihxq.blog.pojo.entity.ArticleDO;
import me.ihxq.blog.pojo.entity.MetricDO;
import me.ihxq.blog.pojo.entity.TagDO;
import org.springframework.data.geo.Metric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/18/018 <br/>
 * time: 19:15 <br/>
 * description:
 */
public interface MetricRepository extends JpaRepository<MetricDO, Integer> {

    Optional<MetricDO> findByArticle(ArticleDO article);
}

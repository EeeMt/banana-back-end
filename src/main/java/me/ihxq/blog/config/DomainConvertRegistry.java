package me.ihxq.blog.config;

import lombok.extern.slf4j.Slf4j;
import me.ihxq.blog.exception.GeneralException;
import me.ihxq.blog.pojo.entity.ArticleDO;
import me.ihxq.blog.pojo.entity.CategoryDO;
import me.ihxq.blog.pojo.entity.MetricDO;
import me.ihxq.blog.pojo.entity.TagDO;
import me.ihxq.blog.pojo.model.DomainPair;
import me.ihxq.blog.pojo.payload.ArticleDTO;
import me.ihxq.blog.pojo.payload.MetricVO;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author xq.h
 * 2019-02-07 02:27
 **/
@Slf4j
@Configuration
public class DomainConvertRegistry {
    private Map<DomainPair, Function> registry = new HashMap<>();

    @PostConstruct
    public void init() {
        add(DomainPair.of(MetricDO.class, MetricVO.class), candidate -> {
            if (candidate == null) {
                return Optional.empty();
            }
            MetricVO metricVO = new MetricVO();
            metricVO.setPv(candidate.getPv());
            metricVO.setLikes(candidate.getLikes());
            metricVO.setDislikes(candidate.getDislikes());
            metricVO.setArticleId(candidate.getArticle().getId());
            return Optional.of(metricVO);
        });

        add(DomainPair.of(ArticleDTO.class, ArticleDO.class), candidate -> {
            if (candidate == null) {
                return Optional.empty();
            } else {
                ArticleDO articleDO = new ArticleDO();
                articleDO.setTitle(candidate.getTitle());
                articleDO.setIntro(candidate.getIntro());
                articleDO.setContent(candidate.getContent());
                articleDO.setDelFlag(false);
                articleDO.setDelTime(null);
                articleDO.setPublished(false);
                articleDO.setPublishTime(null);
                articleDO.setCreateTime(LocalDateTime.now());
                articleDO.setUpdateTime(LocalDateTime.now());
                List<CategoryDO> categoryDOList = candidate.getCategoriesId().stream()
                        .map(CategoryDO::new)
                        .collect(Collectors.toList());
                articleDO.setCategories(categoryDOList);
                List<TagDO> tagDOList = candidate.getTagsId().stream()
                        .map(TagDO::new)
                        .collect(Collectors.toList());
                articleDO.setTags(tagDOList);
                return Optional.of(articleDO);
            }
        });
    }

    public <A, B> DomainConvertRegistry add(DomainPair<A, B> domainPair, Function<A, Optional<B>> converter) {
        registry.put(domainPair, converter);
        return this;
    }

    public <A, B> Function<A, Optional<B>> detect(DomainPair<A, B> domainPair) {
        //noinspection unchecked
        return registry.get(domainPair);
    }

}

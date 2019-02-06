package me.ihxq.blog.service;


import me.ihxq.blog.pojo.entity.ArticleDO;
import me.ihxq.blog.pojo.payload.ArticleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/11/011 <br/>
 * time: 19:05 <br/>
 * description:
 */
public interface ArticleService {

    void save(ArticleDO articleDO);

    Page<ArticleDO> query(Pageable pageable);

    void del(Long articleId);

    Optional<ArticleDO> findById(Long articleId);

    ArticleDO convertToDO(ArticleDTO articleDTO);
}

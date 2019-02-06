package me.ihxq.blog.service;


import me.ihxq.blog.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/11/011 <br/>
 * time: 19:05 <br/>
 * description:
 */
public interface ArticleService {

    void save(Article article);

    Page<Article> query(Pageable pageable);
    /**
     * 逻辑删除
     *
     * @param articleId 文章id
     */
    void del(Long articleId);

    Article find(Long articleId);
}

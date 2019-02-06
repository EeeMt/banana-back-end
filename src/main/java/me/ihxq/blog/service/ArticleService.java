package me.ihxq.blog.service;


import me.ihxq.blog.model.Article;
import org.springframework.data.domain.Page;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/11/011 <br/>
 * time: 19:05 <br/>
 * description:
 */
public interface ArticleService {
    /**
     * 分页查询
     *
     * @param page 页码
     * @param size 页面大小
     */
    Page<Article> query(int page, int size);

    /**
     * 保存或者更新
     *
     * @param article 文章实体
     */
    void saveOrUpdate(Article article);

    /**
     * 逻辑删除
     *
     * @param articleId 文章id
     */
    void del(Long articleId);

    Article detail(Long articleId);
}

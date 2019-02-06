package me.ihxq.blog.repository;


import me.ihxq.blog.pojo.entity.ArticleDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/11/011 <br/>
 * time: 19:06 <br/>
 * description:
 */
public interface ArticleRepository extends JpaRepository<ArticleDO, Long> {
}

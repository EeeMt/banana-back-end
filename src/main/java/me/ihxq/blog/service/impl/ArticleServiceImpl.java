package me.ihxq.blog.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.ihxq.blog.model.Article;
import me.ihxq.blog.repository.ArticleRepository;
import me.ihxq.blog.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/11/011 <br/>
 * time: 19:05 <br/>
 * description:
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleRepository articleRepository;

    @Override
    public Page<Article> query(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void del(Long articleId) {
        Article repositoryOne = articleRepository.findById(articleId).orElseThrow(() -> new RuntimeException(""));
        repositoryOne.setDelFlag(true);
    }

    @Override
    public Article find(Long articleId) {
//        return articleRepository.findById(articleId).orElse(null);
        return null;
    }
}

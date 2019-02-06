package me.ihxq.blog.service.impl;

import me.ihxq.blog.model.Article;
import me.ihxq.blog.repository.ArticleRepository;
import me.ihxq.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/11/011 <br/>
 * time: 19:05 <br/>
 * description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);


    @Resource
    private ArticleRepository articleRepository;

    @Override
    public Page<Article> query(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, "updateTime");
        return null;
        //        return articleRepository.findAll(pageRequest);
    }

    @Override
    public void saveOrUpdate(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void del(Long articleId) {
//        Article repositoryOne = articleRepository.findById(articleId).orElseThrow(() -> new RuntimeException(""));
//        repositoryOne.setDelFlag(true);
    }

    @Override
    public Article detail(Long articleId) {
//        return articleRepository.findById(articleId).orElse(null);
        return null;
    }
}

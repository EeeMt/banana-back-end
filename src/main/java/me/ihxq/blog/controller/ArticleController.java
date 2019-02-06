package me.ihxq.blog.controller;

import me.ihxq.blog.model.Article;
import me.ihxq.blog.repository.ArticleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author xq.h
 * 2019-02-06 19:10
 **/
@RestController
@RequestMapping("article")
public class ArticleController {
    @Resource
    private ArticleRepository articleRepository;


    @GetMapping("2")
    public String test2() {
        return "hello2";
    }

    @GetMapping()
    public Optional<Article> test3() {
        return articleRepository.findById(1L);
    }

}

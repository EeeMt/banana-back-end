package me.ihxq.blog.controller;

import me.ihxq.blog.model.Article;
import me.ihxq.blog.payload.Result;
import me.ihxq.blog.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * author: HuangXiquan <br/>
 * date: 2017/10/30/030 <br/>
 * time: 22:53 <br/>
 * description:
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    private ArticleService articleService;

    @GetMapping({"", "home"})
    public Result<Page<Article>> hello(Pageable pageable) {
        if (pageable == null) {
            pageable = PageRequest.of(0, 10);
        }
        Page<Article> articlePage = articleService.query(pageable);
        return new Result<>(articlePage);
    }

}
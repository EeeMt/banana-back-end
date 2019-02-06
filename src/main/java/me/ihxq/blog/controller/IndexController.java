package me.ihxq.blog.controller;

import me.ihxq.blog.model.Article;
import me.ihxq.blog.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String hello(Integer pageNum, Model model) {
        if (pageNum == null) {
            pageNum = 0;
        }
        Page<Article> articlePage = articleService.query(pageNum, 10);
        model.addAttribute("articlePage", articlePage);
        return "index";
    }

}
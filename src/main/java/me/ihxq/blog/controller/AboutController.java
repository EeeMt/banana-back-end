package me.ihxq.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: HuangXiquan <br>
 * date: 2018-02-20 9:59 <br>
 * description:
 */
@Controller
@RequestMapping("about")
public class AboutController {

    @GetMapping("")
    public String about() {
        return "about";
    }
}

package me.ihxq.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: HuangXiquan <br>
 * date: 2018-02-20 10:04 <br>
 * description:
 */
@Controller
@RequestMapping("contact")
public class ContactController {

    @GetMapping("")
    public String contact() {
        return "contact";
    }
}

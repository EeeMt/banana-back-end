package me.ihxq.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: HuangXiquan <br>
 * date: 2018-02-20 13:32 <br>
 * description:
 */
@Controller
@RequestMapping("guestBook")
public class GuestBookController {

    @RequestMapping("")
    public String guestBook() {
        return "guest_book";
    }
}

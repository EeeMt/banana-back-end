package me.ihxq.blog.controller;

import me.ihxq.blog.config.Metadata;
import me.ihxq.blog.payload.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xq.h
 * 2019-02-06 23:42
 **/
@RestController
@RequestMapping("metadata")
public class MetadataController {

    @Resource
    private Metadata metadata;

    @GetMapping
    public Result<Metadata> get() {
        return new Result<>(metadata);
    }

}

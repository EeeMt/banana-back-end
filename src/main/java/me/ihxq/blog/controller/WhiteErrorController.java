package me.ihxq.blog.controller;

import me.ihxq.blog.payload.Result;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * @author xq.h
 * 2019-02-06 22:12
 **/
@RestController
public class WhiteErrorController extends AbstractErrorController {
    private static final String PATH = "/error";

    public WhiteErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @GetMapping(value = PATH)
    public Result<String> error(ServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String message = (String) request.getAttribute("javax.servlet.error.message");
        return new Result<>(statusCode, message);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}

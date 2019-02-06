package me.ihxq.blog.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author xq.h
 * on 2019-02-06 20:06
 **/
@Getter
public enum RestStatus {
    OK(HttpStatus.OK.value()),
    NOT_FOUND(HttpStatus.NOT_FOUND.value()),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value());

    private int code;

    RestStatus(int code) {
        this.code = code;
    }}

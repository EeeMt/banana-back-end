package me.ihxq.blog.payload;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/10/010 <br/>
 * time: 0:07 <br/>
 * description:
 */
@Data
public class Result<T> implements Serializable {
    private int status;
    private T data;
    private String message;

    public Result(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Result(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result() {
    }

    public Result(T data) {
        this.data = data;
        this.status = HttpStatus.OK.value();
    }
}

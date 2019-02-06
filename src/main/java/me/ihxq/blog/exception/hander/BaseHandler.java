package me.ihxq.blog.exception.hander;

import javassist.NotFoundException;
import me.ihxq.blog.payload.Result;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * author: HuangXiquan <br/>
 * date: 2017/10/30/030 <br/>
 * time: 23:50 <br/>
 * description:
 */
@RestControllerAdvice
public class BaseHandler {

    private Logger logger = getLogger(BaseHandler.class);


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notFound() {
        return "not found";
    }

    @ExceptionHandler(Throwable.class)
    public Result error(Throwable e) {
        logger.error("error : ", e);
        return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
    }
}

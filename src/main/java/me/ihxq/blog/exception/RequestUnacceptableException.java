package me.ihxq.blog.exception;

/**
 * author: HuangXiquan <br/>
 * date: 2017/10/31/031 <br/>
 * time: 23:03 <br/>
 * description:
 */
public class RequestUnacceptableException extends Exception{
    public RequestUnacceptableException() {
        super();
    }

    public RequestUnacceptableException(String message) {
        super(message);
    }
}

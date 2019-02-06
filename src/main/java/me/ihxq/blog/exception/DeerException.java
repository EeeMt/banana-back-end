package me.ihxq.blog.exception;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/11/011 <br/>
 * time: 19:24 <br/>
 * description:
 */
public class DeerException extends Exception {

    private String message;

    public DeerException() {
        super();
    }

    public DeerException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public DeerException(String format, Object... params) {
        super(format);
        this.message = formatMessage(format, params);
    }

    public DeerException(String message, Throwable cause) {
        super(message, cause);
    }

    private static String formatMessage(String format, Object... params) {
        if (StringUtils.isBlank(format)) {
            return format;
        } else {
            String message = format;
            if (params != null) {
                for (Object param : params) {
                    message = StringUtils.replaceOnce(message, "{}", param.toString());
                }
                message = message.replaceAll("\\{}", "");
                if (params.length >= 1) {
                    Object e = params[params.length - 1];
                    if (e instanceof Throwable) {
                        message += "\n" + ExceptionUtils.getStackTrace((Throwable) e);
                    }
                }
            } else {
                message = message.replaceAll("\\{}", "");
            }
            return message;
        }
    }

}

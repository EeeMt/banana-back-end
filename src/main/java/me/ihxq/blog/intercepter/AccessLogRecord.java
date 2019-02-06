package me.ihxq.blog.intercepter;

import me.ihxq.blog.model.AccessLog;
import me.ihxq.blog.service.AccessLogService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessLogRecord extends HandlerInterceptorAdapter {

    @Resource
    private AccessLogService accessLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AccessLog accessLog = this.extractAccessLog(request);
        accessLogService.save(accessLog);

        return super.preHandle(request, response, handler);
    }

    private AccessLog extractAccessLog(HttpServletRequest request) {
        return null;
    }
}

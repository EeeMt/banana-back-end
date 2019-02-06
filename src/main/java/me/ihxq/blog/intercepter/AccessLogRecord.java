package me.ihxq.blog.intercepter;

import me.ihxq.blog.pojo.entity.AccessLogDO;
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
        AccessLogDO accessLogDO = this.extractAccessLog(request);
        accessLogService.save(accessLogDO);

        return super.preHandle(request, response, handler);
    }

    private AccessLogDO extractAccessLog(HttpServletRequest request) {
        return null;
    }
}

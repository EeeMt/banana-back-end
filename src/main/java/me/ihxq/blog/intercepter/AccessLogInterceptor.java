package me.ihxq.blog.intercepter;

import lombok.extern.slf4j.Slf4j;
import me.ihxq.blog.pojo.entity.AccessLogDO;
import me.ihxq.blog.service.AccessLogService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Component
@Slf4j
public class AccessLogInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private AccessLogService accessLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AccessLogDO accessLogDO = this.extractAccessLog(request);
        accessLogService.save(accessLogDO);

        return super.preHandle(request, response, handler);
    }

    private AccessLogDO extractAccessLog(HttpServletRequest request) {
        String ipAddress = this.extractIp(request);
        String requestUri = this.extractUri(request);
        String requestMethod = this.extractRequestMethod(request);
        AccessLogDO accessLogDO = new AccessLogDO();
        accessLogDO.setIp(ipAddress);
        accessLogDO.setRequestMethod(requestMethod);
        accessLogDO.setAccessUrl(requestUri);
        accessLogDO.setAccessTime(LocalDateTime.now());
        return accessLogDO;
    }

    private String extractRequestMethod(HttpServletRequest request) {
        return request.getMethod();
    }

    private String extractUri(HttpServletRequest request) {
        return request.getRequestURI();
    }

    private String extractIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        String from = "X-Forwarded-For";
        log.debug("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                from = "Proxy-Client-IP";
                log.debug("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                from = "WL-Proxy-Client-IP";
                log.debug("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                from = "HTTP_CLIENT_IP";
                log.debug("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                from = "HTTP_X_FORWARDED_FOR";
                log.debug("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                from = "getRemoteAddr";
                log.debug("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (String ip1 : ips) {
                if (!("unknown".equalsIgnoreCase(ip1))) {
                    ip = ip1;
                    break;
                }
            }
        }
        log.info("Detect request ip: {}, extracted from : {}", ip, from);
        return ip;
    }

}

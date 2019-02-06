package me.ihxq.blog.config;

import me.ihxq.blog.intercepter.AccessLogInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author xq.h
 * 2019-02-06 23:16
 **/
@Configuration
@EnableConfigurationProperties(Metadata.class)
public class AppConfig implements WebMvcConfigurer {

    @Resource
    private AccessLogInterceptor accessLogInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessLogInterceptor).addPathPatterns("/**");
    }
}

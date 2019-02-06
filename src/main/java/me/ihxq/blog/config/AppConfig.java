package me.ihxq.blog.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xq.h
 * 2019-02-06 23:16
 **/
@Configuration
@EnableConfigurationProperties(Metadata.class)
public class AppConfig {
}

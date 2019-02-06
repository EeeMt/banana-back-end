package me.ihxq.blog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author xq.h
 * 2019-02-06 23:10
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "metadata")
public class Metadata {
    private List<String> emails;
    private String phone;
    private String wechatQr;
}

package me.ihxq.blog.pojo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "access_log")
public class AccessLogDO {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String ip;

    @NotNull
    private String requestMethod;

    @NotNull
    private String accessUrl;

    @NotNull
    private LocalDateTime accessTime;

}

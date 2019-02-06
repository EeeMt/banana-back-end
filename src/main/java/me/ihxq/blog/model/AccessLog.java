package me.ihxq.blog.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class AccessLog {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String ip;

    @NotNull
    private String accessUrl;

    @NotNull
    private LocalDateTime accessTime;

}

package me.ihxq.blog.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/19/019 <br/>
 * time: 13:35 <br/>
 * description:
 */
@Entity
@Data
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String content;
    @NotNull
    private String ipAddress;
    @Null
    private String nickName;
    @Null
    private String email;
    @NotNull
    private LocalDateTime publishTime;
    @NotNull
    private boolean isDeleted;
    @Null
    private LocalDateTime delTime;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "article_id")
    private Article article;
}

package me.ihxq.blog.pojo.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
public class CommentDO {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String content;
    @NotNull
    private String ipAddress;
    private String nickName;
    private String email;
    @NotNull
    private LocalDateTime publishTime;
    @NotNull
    private boolean isDeleted;
    private LocalDateTime delTime;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "article_id", nullable = false)
    private ArticleDO article;
}

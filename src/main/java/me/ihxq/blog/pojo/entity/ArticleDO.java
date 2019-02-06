package me.ihxq.blog.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * author: HuangXiquan <br/>
 * date: 2017/10/31/031 <br/>
 * time: 23:05 <br/>
 * description: 文章
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "article")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
public class ArticleDO {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    /**
     * 标题
     */
    @NotNull
    private String title;
    /**
     * 文章内容
     */
    @Type(type = "text")
    @NotNull
    private String content;
    /**
     * 文章简介
     */
    private String intro;

    /**
     * 分类
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinTable(name = "category_article", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryDO> categories;
    /**
     * 标签
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinTable(name = "tag_article", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagDO> tags;

    /**
     * 评论
     */
    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private List<CommentDO> comments;

    /**
     * 是否发布
     */
    @NotNull
    private boolean published;
    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 是否删除
     */
    @ColumnDefault("false")
    @NotNull
    private boolean delFlag = false;
    /**
     * 删除日期
     */
    private LocalDateTime delTime;

    /**
     * 创建时间
     */
    @Column(updatable = false)
    @ColumnDefault("current_timestamp")
    @NotNull
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @ColumnDefault("current_timestamp")
    @NotNull
    @UpdateTimestamp
    private LocalDateTime updateTime;

    public ArticleDO(long id) {
        this.id = id;
    }

    @PreUpdate
    public void preUpdate() {
//        updateTime = LocalDateTime.now();
    }
}

package me.ihxq.blog.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * author: HuangXiquan <br/>
 * date: 2017/10/31/031 <br/>
 * time: 23:17 <br/>
 * description: 文章分类
 */
@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @NotNull
    private String name;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "category_article", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "article_id"))
    private List<Article> articles;
}

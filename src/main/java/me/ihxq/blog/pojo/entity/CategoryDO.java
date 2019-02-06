package me.ihxq.blog.pojo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * author: HuangXiquan <br/>
 * date: 2017/10/31/031 <br/>
 * time: 23:17 <br/>
 * description: 文章分类
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "category")
public class CategoryDO {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @NotNull
    private String name;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "category_article", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "article_id"))
    private List<ArticleDO> articleS;

    public CategoryDO(long id) {
        this.id = id;
    }
}

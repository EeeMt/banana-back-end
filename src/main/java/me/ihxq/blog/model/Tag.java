package me.ihxq.blog.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * author: HuangXiquan <br/>
 * date: 2017/10/31/031 <br/>
 * time: 23:59 <br/>
 * description:
 */
@Entity
@Data
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @NotNull
    private String name;
    private String description;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "tag_article",joinColumns = @JoinColumn(name = "tag_id"),inverseJoinColumns = @JoinColumn(name = "article_id"))
    private List<Article> articles;

}

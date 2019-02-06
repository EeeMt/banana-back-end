package me.ihxq.blog.pojo.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import sun.rmi.runtime.Log;

import javax.persistence.*;


/**
 * @author xq.h
 * 2019-02-07 01:23
 **/
@Data
@Entity
@Table(name = "metric")
public class MetricDO {
    @Id
    @GeneratedValue
    private Long id;

    private long likes;
    private long dislikes;
    private long pv;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "article_id")
    private ArticleDO article;
}

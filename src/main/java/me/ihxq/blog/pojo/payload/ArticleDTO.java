package me.ihxq.blog.pojo.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ArticleDTO {
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 文章简介
     */
    private String intro;

    private List<Long> categoriesId;
    private List<Long> tagsId;
}

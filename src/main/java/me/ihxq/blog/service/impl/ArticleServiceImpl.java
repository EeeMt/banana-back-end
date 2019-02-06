package me.ihxq.blog.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.ihxq.blog.exception.RequestUnacceptableException;
import me.ihxq.blog.pojo.entity.ArticleDO;
import me.ihxq.blog.pojo.entity.CategoryDO;
import me.ihxq.blog.pojo.entity.TagDO;
import me.ihxq.blog.pojo.payload.ArticleDTO;
import me.ihxq.blog.repository.ArticleRepository;
import me.ihxq.blog.service.ArticleService;
import me.ihxq.blog.service.CategoryService;
import me.ihxq.blog.service.TagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/11/011 <br/>
 * time: 19:05 <br/>
 * description:
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private CategoryService categoryService;

    @Resource
    private TagService tagService;

    @Override
    public Page<ArticleDO> query(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public void save(ArticleDO articleDO) {
        articleRepository.save(articleDO);
    }

    @Override
    public void del(Long articleId) {
        ArticleDO repositoryOne = articleRepository.findById(articleId).orElseThrow(() -> new RequestUnacceptableException("Article not found!"));
        repositoryOne.setDelFlag(true);
        repositoryOne.setDelTime(LocalDateTime.now());
        articleRepository.save(repositoryOne);
    }

    @Override
    public Optional<ArticleDO> findById(Long articleId) {
        return articleRepository.findById(articleId);
    }

    @Override
    public ArticleDO convertToDO(ArticleDTO articleDTO) {
        if (articleDTO == null) {
            return null;
        } else {
            ArticleDO articleDO = new ArticleDO();
            articleDO.setTitle(articleDTO.getTitle());
            articleDO.setIntro(articleDTO.getIntro());
            articleDO.setContent(articleDTO.getContent());
            articleDO.setDelFlag(false);
            articleDO.setDelTime(null);
            articleDO.setPublished(false);
            articleDO.setPublishTime(null);
            articleDO.setCreateTime(LocalDateTime.now());
            articleDO.setUpdateTime(LocalDateTime.now());
            List<CategoryDO> categoryDOList = articleDTO.getCategoriesId().stream()
                    .map(categoryId -> categoryService.findById(categoryId))
                    .collect(Collectors.toList());
            articleDO.setCategories(categoryDOList);
            List<TagDO> tagDOList = articleDTO.getTagsId().stream()
                    .map(tagId -> tagService.findById(tagId))
                    .collect(Collectors.toList());
            articleDO.setTags(tagDOList);
            return articleDO;
        }
    }
}

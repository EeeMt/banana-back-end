package me.ihxq.blog.repository;

import me.ihxq.blog.pojo.entity.TagDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/18/018 <br/>
 * time: 19:15 <br/>
 * description:
 */
public interface TagRepository extends JpaRepository<TagDO, Integer> {
}

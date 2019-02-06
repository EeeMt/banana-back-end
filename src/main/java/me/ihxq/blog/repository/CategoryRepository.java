package me.ihxq.blog.repository;


import me.ihxq.blog.pojo.entity.CategoryDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: HuangXiquan <br/>
 * date: 2017/11/18/018 <br/>
 * time: 19:14 <br/>
 * description:
 */
public interface CategoryRepository extends JpaRepository<CategoryDO, Integer> {
}

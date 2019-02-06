package me.ihxq.blog.repository;

import me.ihxq.blog.pojo.entity.AccessLogDO;
import me.ihxq.blog.pojo.entity.TagDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessLogRepository extends JpaRepository<AccessLogDO, Integer> {
}

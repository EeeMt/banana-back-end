package me.ihxq.blog.service.impl;

import me.ihxq.blog.pojo.entity.AccessLogDO;
import me.ihxq.blog.repository.AccessLogRepository;
import me.ihxq.blog.service.AccessLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.print.Pageable;
import java.util.List;

/**
 * @author xq.h
 * 2019-02-06 23:53
 **/
@Service
public class AccessLogServiceImpl implements AccessLogService {

    @Resource
    private AccessLogRepository accessLogRepository;

    @Override
    public void save(AccessLogDO accessLogDO) {
        accessLogRepository.save(accessLogDO);
    }

    @Override
    public List<AccessLogDO> query(Pageable pageable) {
        return null;
    }
}

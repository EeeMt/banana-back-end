package me.ihxq.blog.service.impl;

import me.ihxq.blog.pojo.entity.AccessLogDO;
import me.ihxq.blog.service.AccessLogService;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author xq.h
 * 2019-02-06 23:53
 **/
@Service
public class AccessLogServiceImpl implements AccessLogService {
    @Override
    public void save(AccessLogDO accessLogDO) {

    }

    @Override
    public List<AccessLogDO> query(Pageable pageable) {
        return null;
    }
}

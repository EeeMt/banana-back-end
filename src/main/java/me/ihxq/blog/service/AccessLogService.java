package me.ihxq.blog.service;

import me.ihxq.blog.model.AccessLog;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author xq.h
 * 2019-02-06 23:50
 **/
public interface AccessLogService {

    void save(AccessLog accessLog);

    List<AccessLog> query(Pageable pageable);
}

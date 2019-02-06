package me.ihxq.blog.service;

/**
 * @author xq.h
 * 2019-02-07 01:59
 **/
public interface DomainConvertService {

    <A, B> B convert(A src, Class<B> destType);

}

package me.ihxq.blog.pojo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import me.ihxq.blog.exception.GeneralException;

/**
 * @author xq.h
 * 2019-02-07 02:28
 **/
@Getter
@EqualsAndHashCode(of = {"src", "dest"})
public class DomainPair<A, B> {
    private Class<A> src;
    private Class<B> dest;

    private DomainPair(Class<A> src, Class<B> dest) {
        this.src = src;
        this.dest = dest;
    }

    public static <A, B> DomainPair<A, B> of(Class<A> src, Class<B> dest) {
        if (src == null || dest == null) {
            throw new GeneralException("Args can not be null");
        }
        return new DomainPair<>(src, dest);
    }
}

package me.ihxq.blog.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.ihxq.blog.config.DomainConvertRegistry;
import me.ihxq.blog.exception.GeneralException;
import me.ihxq.blog.pojo.model.DomainPair;
import me.ihxq.blog.service.DomainConvertService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author xq.h
 * 2019-02-07 01:59
 **/
@Slf4j
@Service
public class DomainConvertServiceImpl implements DomainConvertService {

    @Resource
    private DomainConvertRegistry convertRegistry;

    @Override
    public <A, B> B convert(A src, Class<B> destType) {
        if (src == null) {
            return null;
        }
        //noinspection unchecked
        Function<A, Optional<B>> converter = (Function<A, Optional<B>>) convertRegistry.detect(DomainPair.of(src.getClass(), destType));
        if (converter == null) {
            log.error("No converter found for {} -> {}", src.getClass().getSimpleName(), destType.getSimpleName());
            throw new GeneralException("No converter found");
        }
        return converter.apply(src).orElseThrow(() -> new GeneralException("convert result null"));
    }
}

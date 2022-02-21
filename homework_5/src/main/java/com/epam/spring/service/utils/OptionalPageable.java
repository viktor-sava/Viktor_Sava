package com.epam.spring.service.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;

import java.util.Objects;
import java.util.stream.Stream;

public class OptionalPageable {
    public static Pageable ofNullable(@Nullable Integer page, @Nullable Integer size, @Nullable String[] fields) {
        Pageable pageable = Pageable.unpaged();
        if (!Stream.of(page, size).allMatch(Objects::isNull)) {
            if (fields == null || fields.length == 0) {
                pageable = PageRequest.of(page, size);
            } else {
                pageable = PageRequest.of(page, size, Sort.by(fields));
            }
        }
        return pageable;
    }
}

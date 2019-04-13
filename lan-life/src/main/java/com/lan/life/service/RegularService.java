package com.lan.life.service;

import com.lan.life.domain.Regular;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author lan
 * @date 2019-03-04 02:29
 */
public interface RegularService {
    List<Regular> findAll();

    void add(Regular regular);

    Regular findById(Long id);

    void delete(Long id);

    Page<Regular> findPage(Integer page, Integer size);
}

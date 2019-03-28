package com.lan.file.service;

import com.lan.file.domain.UpFile;

import java.util.List;

/**
 * @author lan
 * @date 2019-03-04 02:29
 */
public interface UpFileService {
    List<UpFile> findAll();

    void upload(UpFile upFile);
}

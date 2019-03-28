package com.lan.file.service.impl;

import com.lan.file.dao.UpFileDao;
import com.lan.file.domain.UpFile;
import com.lan.file.service.UpFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lan
 * @date 2019-03-04 02:29
 */
@Service
public class UpFileServiceImpl implements UpFileService {
    @Autowired
    private UpFileDao upFileDao;


    @Override
    public List<UpFile> findAll() {
        return upFileDao.findAll();
    }

    @Override
    public void upload(UpFile file) {
        file.setFileState("1")
                .setCreateTime(new Date())
                .setUpdateTime(new Date());
        upFileDao.save(file);

    }
}

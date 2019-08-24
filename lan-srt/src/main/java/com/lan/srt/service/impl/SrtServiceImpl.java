package com.lan.srt.service.impl;

import com.lan.srt.dao.SrtDao;
import com.lan.srt.domain.UserInfo;
import com.lan.srt.service.SrtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SrtServiceImpl implements SrtService {

    @Autowired
    private SrtDao srtDao;

    public SrtServiceImpl() {
    }

    public List<UserInfo> findAll() {
        return this.srtDao.findAll();
    }

    public void save(UserInfo userInfo) {
        this.srtDao.save(userInfo);
    }
}

package com.lan.srt.service;

import com.lan.srt.domain.UserInfo;

import java.util.List;

public interface SrtService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);
}

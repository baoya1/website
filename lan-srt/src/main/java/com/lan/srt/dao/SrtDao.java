package com.lan.srt.dao;

import com.lan.srt.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SrtDao extends JpaRepository<UserInfo,Long> {
}

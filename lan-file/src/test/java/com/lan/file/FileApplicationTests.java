package com.lan.file;

import com.lan.file.dao.UpFileDao;
import com.lan.file.domain.UpFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileApplicationTests {
    @Autowired
    private UpFileDao upFileDao;

    @Test
    public void contextLoads() {
        UpFile upFile = new UpFile().setFileName("swx.jpg")
                .setFilePath("1")
                .setCreateTime(new Date())
                .setUpdateTime(new Date());

        upFileDao.save(upFile);
    }


}

package com.lan.file.controller;

import com.lan.file.domain.UpFile;
import com.lan.file.service.UpFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @author lan
 * @date 2019-03-04 02:28
 */
@RestController
@RequestMapping("/upFile")
public class UpFileController {

    @Autowired
    private UpFileService upFileService;

    @Value("${file.path.prefix}")
    private String pathPrefix;

    @Value("${file.url.prefix}")
    private String urlPrefix;

    @GetMapping
    public List<UpFile> findAll() {
        return upFileService.findAll();
    }

    @PostMapping
    public String upload(@RequestParam("upFile") MultipartFile upFile) {
        try {
            String filename = upFile.getOriginalFilename();
            UpFile newUpFile = new UpFile();
            String path = pathPrefix + filename;
            newUpFile.setFilePath(path)
                    .setFileUrl(urlPrefix + filename)
                    .setFileName(filename)
                    .setFileSize(upFile.getSize());
            File file = new File(path);
            upFile.transferTo(file);
            upFileService.upload(newUpFile);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }

}

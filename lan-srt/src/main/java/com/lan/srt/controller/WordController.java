package com.lan.srt.controller;

import com.lan.srt.domain.UserInfo;
import com.lan.srt.service.SrtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping({"/word"})
public class WordController {
    @Autowired
    private SrtService srtService;
    @Value("${file.path.prefix}")
    private String pathPrefix;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    public WordController() {
    }

    @GetMapping
    public List<UserInfo> findAll() {
        return this.srtService.findAll();
    }

    @PostMapping
    public void upload(@RequestParam("file") MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            String[] split = filename.split("\\.");
            filename = split[0] + "_new." + split[1];
            String path = this.pathPrefix + filename;
            File newFile = new File(path);
            file.transferTo(newFile);
            UserInfo userInfo = new UserInfo();
            String addr = this.request.getRemoteAddr();
            String userAgent = this.request.getHeader("User-Agent");
            userInfo.setFileName(filename).setUserAddr(addr).setUserAgent(userAgent).setOperationTime(new Date());
            this.srtService.save(userInfo);
            this.response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "utf-8"));
            this.response.setContentType("text/plain;charset=utf-8");
            PrintWriter writer = this.response.getWriter();
            this.convertWord(newFile, writer);

        } catch (Exception var10) {
            var10.printStackTrace();
        }

    }

    private void convertWord(File file, PrintWriter writer) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
        String line = null;
        String regex1 = "[\\u4e00-\\u9fa5]";
        Pattern pattern1 = Pattern.compile(regex1);

        while((line = br.readLine()) != null) {
            Matcher matcher = pattern1.matcher(line);
            line = matcher.replaceAll("");
            line = line.replaceAll("[\\?\\!\\.]", "$0 ");
            if (line.length() != 0) {
                writer.println(line);
            }
        }

        br.close();
        writer.close();
        file.delete();
    }
}
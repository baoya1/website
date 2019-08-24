package com.lan.srt.controller;

import com.lan.srt.domain.UserInfo;
import com.lan.srt.service.SrtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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
@RequestMapping({"/srt"})
public class SrtController {
    @Autowired
    private SrtService srtService;
    @Value("${file.path.prefix}")
    private String pathPrefix;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    public SrtController() {
    }

    @GetMapping
    public List<UserInfo> findAll() {
        return this.srtService.findAll();
    }

    @PostMapping
    public void upload(@RequestParam("file") MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            if (!filename.endsWith(".srt")) {
                return;
            }

            String path = this.pathPrefix + filename.replace(".srt", ".txt");
            File newFile = new File(path);
            file.transferTo(newFile);
            UserInfo userInfo = new UserInfo();
            String addr = this.request.getRemoteAddr();
            String userAgent = this.request.getHeader("User-Agent");
            userInfo.setFileName(filename).setUserAddr(addr).setUserAgent(userAgent).setOperationTime(new Date());
            this.srtService.save(userInfo);
            this.response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename.replace(".srt", ".txt"), "utf-8"));
            this.response.setContentType("text/plain;charset=utf-8");
            PrintWriter writer = this.response.getWriter();
            this.convertSrt(newFile, writer);
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }

    private void convertSrt(File file, PrintWriter writer) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_16LE));
        String line = null;
        br.readLine();

        while((line = br.readLine()) != null) {
            if (line.length() != 0) {
                Pattern patternNum = Pattern.compile("^\\+?[1-9][0-9]*$", 8);
                Matcher m1 = patternNum.matcher(line);
                Pattern patternTime = Pattern.compile("([^\\n-]*)\\s*-->\\s*([^\\n-]*)[\\r\\n]?([^<]*)", 8);
                Matcher m2 = patternTime.matcher(line);
                if (!m1.find() && !m2.find()) {
                    writer.println(line);
                }
            }
        }

        br.close();
        writer.close();
        file.delete();
    }
}

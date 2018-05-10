package com.example.springboot.controller;

import com.example.springboot.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IDEA
 * Author: GuiqiHu
 * Created in: 2018/5/2 15:03
 */

@Controller
public class FileUploadController {

    @RequestMapping("/goFileUpload")
    public String goFileUpload() {
        System.out.println("jinlaile");
        return "file1";
    }

    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        String contextType = file.getContentType();
        System.out.println("上传的文件类型:" + contextType);
        String fileName = file.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {

        }
        return "upload success!";
    }
}
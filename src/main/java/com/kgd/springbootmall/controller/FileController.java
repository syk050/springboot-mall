package com.kgd.springbootmall.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@RestController
@CrossOrigin
public class FileController {

    @PostMapping("/kgd/img")
    public String requestUploadFile(@RequestParam("fileList") List<MultipartFile> fileList) {
        try {
            for (MultipartFile multipartFile : fileList) {
                FileOutputStream writer = new FileOutputStream("./images/" + multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "upload fail";
        }
        return "upload success";
    }
}

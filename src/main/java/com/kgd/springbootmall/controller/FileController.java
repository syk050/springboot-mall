package com.kgd.springbootmall.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public class FileController {

    @PostMapping("/kgd/img")
    public boolean requestUploadFile(@RequestParam("fileList") List<MultipartFile> fileList) {
        try {
            for (MultipartFile multipartFile : fileList) {
                /* uuid
                 * 파일에 고유한 이름을 가지도록 하기 위해
                 * 국제기구에서 표준으로 정한 식별자(일련번호)
                 */
                String uuid = UUID.randomUUID().toString();
                String fileName = uuid + "_" + multipartFile.getOriginalFilename();

                FileOutputStream writer = new FileOutputStream("./images/" + fileName);
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            return "upload fail";
            return false;
        }
//        return "upload success";
        return true;
    }
}

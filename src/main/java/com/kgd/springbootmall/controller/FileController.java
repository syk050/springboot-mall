package com.kgd.springbootmall.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONObject;

@RestController
@CrossOrigin
public class FileController {

    @PostMapping("/kgd/img")
    public JSONObject requestUploadFile(@RequestParam("fileList") List<MultipartFile> fileList) {
        JSONObject path;
        try {
            path = new JSONObject();

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

                path.put("url", "/kgd/img/" + fileName);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            return "upload fail";
            return new JSONObject();
        }
//        return "upload success";
        return path;
    }

    @GetMapping("/kgd/img/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename){

        File file = new File("D:\\IntelliJProjects\\springboot-mall\\images\\" + filename);
        ResponseEntity<byte[]> result = null;
        try {

            HttpHeaders header = new HttpHeaders();

            header.add("Content-type", Files.probeContentType(file.toPath()));

            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);

        }catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}

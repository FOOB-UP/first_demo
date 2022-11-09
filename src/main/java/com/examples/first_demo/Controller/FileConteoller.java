package com.examples.first_demo.Controller;

import com.sun.activation.registries.MailcapFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
public class FileConteoller  {

    @RequestMapping(value = "/file",method = RequestMethod.GET)
    public String file(String name, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(name);
        //获取图片名称
        System.out.println(file.getOriginalFilename());
        //获取图片类型
        System.out.println(file.getContentType());

        //获取图片大小
        System.out.println(file.getSize());

        //获取图片路径
        log.info("文件上传开始");
        log.info("文件{}",file.getOriginalFilename());

        if (!file.isEmpty()){
            try {
                //上传的文件需要保存的路径和文件名称，路径需要存在，否则报错
                file.transferTo(new File("/Users/anker/Desktop/data/first_demo/src/main/resources/static/"+file.getOriginalFilename()));
            } catch (IllegalStateException | IOException e){
                e.printStackTrace();
                return "上传失败";
            }
        } else {
            return "请上传文件";
        }
        return "上传成功";
    }

    @RequestMapping("/dowd")
    public ResponseEntity<Object> download() throws IOException {
        //提供下载的文件的路径
        FileSystemResource file = new FileSystemResource("/Users/anker/Desktop/data/first_demo/src/main/resources/static/头像.jpeg");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        //这里定制下载文件的名称
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))//以二进制流的形式返回
                .body(new InputStreamResource(file.getInputStream()));
    }
}

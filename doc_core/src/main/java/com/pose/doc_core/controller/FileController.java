package com.pose.doc_core.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.path.real}")
    private String  DEFAULT_PATH = "/tmp/image/";

    @PostMapping(value = {"/image"})
    public String imageUpload(@RequestParam(value = "file") MultipartFile file){
        if(file.isEmpty()){
            //
        }

        String filename  = file.getOriginalFilename();

        String suffixName = filename.substring(filename.lastIndexOf("."));  // 后缀名

        //String path = "/Users/poseture/images/";

        String newName = new ObjectId().toString()+suffixName;

        System.out.println("-----------------"+DEFAULT_PATH+newName);
        File dest = new File(DEFAULT_PATH+newName);



        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "doc-api/"+newName;

    }
}

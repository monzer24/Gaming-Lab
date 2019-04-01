package com.gaming.lab.controller;

import com.gaming.lab.data.Course;
import com.gaming.lab.data.LabInfo;
import com.gaming.lab.data.PostRepository;
import lombok.val;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.sql.rowset.BaseRowSet;
import java.awt.image.BufferedImage;
import java.io.*;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private PostRepository repo;

    public AdminController(PostRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String admin(){
        return "admin";
    }

    @PostMapping
    public void post(MultipartFile image, String city){
        LabInfo lab = new LabInfo();
        System.out.println(city);
        lab.lab = LabInfo.LabCity.valueOf(city.toUpperCase());
        System.out.println("Posting");
        System.out.println(lab);
        Course course = new Course(encode(image), lab);
        System.out.println(course.getLab().lab.getColor());
        repo.save(course);
        System.out.println("done");
    }

    private String encode(MultipartFile image){
        String imageString = null;
        try{
            InputStream input = image.getInputStream();
            BufferedImage img = ImageIO.read(input);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(img, "png", out);
            byte[] imageBytes = out.toByteArray();
            imageString = Base64.encodeBase64String(imageBytes);
        }catch (Exception e){

        }
        return imageString;
    }

}

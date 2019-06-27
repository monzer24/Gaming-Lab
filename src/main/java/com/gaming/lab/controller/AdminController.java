package com.gaming.lab.controller;

import com.gaming.lab.data.Course;
import com.gaming.lab.data.LabInfo;
import com.gaming.lab.data.PostRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;

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
        lab.lab = LabInfo.LabCity.valueOf(city.toUpperCase());
        Course course = new Course(encode(image), lab);
        course.setPostedAt(new Date());
        repo.save(course);
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

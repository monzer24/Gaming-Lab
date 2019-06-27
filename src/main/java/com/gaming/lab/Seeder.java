package com.gaming.lab;

import com.gaming.lab.data.CourseRepository;
import com.gaming.lab.data.User;
import com.gaming.lab.data.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;

@Component
public class Seeder implements CommandLineRunner {

    private UserRepository repo;
    private CourseRepository courseRepo;

    @Autowired
    public Seeder(UserRepository repo, CourseRepository courseRepo) {
        this.repo = repo;
        this.courseRepo = courseRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        User ahmad = new User(
                "ahmad ali",
                "ahmad@gmail.com",
                "12345",
                "0778965123",
                User.Gender.MALE,
                "12425342",
                "developer",
                new Date(),
                User.City.AMMAN,
                User.Education.SCHOOL,
                false);

        User ali = new User(
                "ali smaer",
                "ali@gmail.com",
                "67890",
                "0778965522",
                User.Gender.MALE,
                "12425342",
                "developer",
                new Date(),
                User.City.ZARQA,
                User.Education.SCHOOL,
                true);

        User amal = new User(
                "amal ali",
                "amal@gmail.com",
                "24680",
                "0778965177",
                User.Gender.FEMALE,
                "12425342",
                "developer",
                new Date(),
                User.City.IRBID,
                User.Education.UNIVERSITY,
                false);

//        System.out.println("seeder addded");
//        repo.deleteAll();

//        List<User> all = Arrays.asList(ahmad, ali, amal);
//        repo.saveAll(all);
    }

    private String encode(BufferedImage image){
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, "png", bos);
            byte[] imageBytes = bos.toByteArray();
            imageString = Base64.encodeBase64String(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

}

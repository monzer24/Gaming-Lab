package com.gaming.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class LabApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabApplication.class, args);
        System.out.println("http://localhost:8080/login");
        System.out.println("http://localhost:8080/signup");
        System.out.println("http://localhost:8080/home");
        System.out.println("http://localhost:8080/course");
        System.out.println("http://localhost:8080/admin");

    }

}

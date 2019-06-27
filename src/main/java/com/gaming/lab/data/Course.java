package com.gaming.lab.data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "Courses")
public class Course {

    @Autowired
    public Course(String courseImage, LabInfo lab) {
        this.courseImage = courseImage;
        this.lab = lab;
        students = new ArrayList<>();
    }

    @Id
    private String id;
    private String courseImage;
    private LabInfo lab;
    private Date postedAt;

    private List<User> students;

    public void addStudent(User user){
        if(!students.contains(user))
        students.add(user);
    }

}

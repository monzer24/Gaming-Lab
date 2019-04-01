package com.gaming.lab.data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "Courses")
public class Course {

    @Autowired
    public Course(String courseImage, LabInfo lab) {
        this.courseImage = courseImage;
        this.lab = lab;
    }

    @Id
    private String id;
    private String courseImage;
    private LabInfo lab;

    private List<User> students;


}

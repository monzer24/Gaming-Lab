package com.gaming.lab.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String>{

    Course findCourseByCity();

}

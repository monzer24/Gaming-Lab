package com.gaming.lab.data;

import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String>{



}

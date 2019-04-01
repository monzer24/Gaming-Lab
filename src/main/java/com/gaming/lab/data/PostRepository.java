package com.gaming.lab.data;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Course, String> {

}

package com.bootcamp.utils;

import com.bootcamp.entities.Course;
import com.bootcamp.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by fathoni on 16/10/14.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final CourseRepository courseRepo;

    @Autowired
    public DataLoader(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.courseRepo.save(new Course("Building Applications in React and Flux","Cory House","Javascript","5:00"));
        this.courseRepo.save(new Course("Building Applications in React and Redux","Cory House","Javascript","5:00"));
        this.courseRepo.save(new Course("Building Applications in Angular","Cory House","Javascript","5:00"));
    }
}

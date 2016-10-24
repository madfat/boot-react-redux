package com.bootcamp.controllers;

import com.bootcamp.entities.Course;
import com.bootcamp.repositories.AuthorRepository;
import com.bootcamp.repositories.CourseRepository;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fathoni on 16/10/14.
 */
@RestController
public class CourseController {
    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    AuthorRepository authorRepo;

    @RequestMapping(value="/api/courses", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> courses() {
        List<Course> courses = (List<Course>)courseRepo.findAll();
        courses.forEach(course -> {
            if (!StringUtils.isEmpty(course.getAuthorId())){
                course.setAuthor(authorRepo.findOne(Long.valueOf(course.getAuthorId())));
            }
        });
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value="/api/courses", method = RequestMethod.POST)
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        try {
            courseRepo.save(course);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

}

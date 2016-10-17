package com.bootcamp.controllers;

import com.bootcamp.entities.Course;
import com.bootcamp.repositories.CourseRepository;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value="/courses/", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> courses() {
        List<Course> courses = (List<Course>)courseRepo.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }


}

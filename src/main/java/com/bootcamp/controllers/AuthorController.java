package com.bootcamp.controllers;

import com.bootcamp.repositories.AuthorRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fathoni on 16/10/18.
 */
@RestController
public class AuthorController {
    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AuthorRepository authorRepo;

}

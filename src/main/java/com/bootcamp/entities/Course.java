package com.bootcamp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by fathoni on 16/10/14.
 */
@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @Column(name="title", columnDefinition = "nvarchar(50)")
    private String title;

    @Column(name="author", columnDefinition = "nvarchar(50)")
    private String author;

    @Column(name="category", columnDefinition = "nvarchar(50)")
    private String category;

    @Column(name="length", columnDefinition = "nvarchar(10)")
    private String length;

    private Course(){};

    public Course(String title, String author, String category, String length){
        this.title = title;
        this.author = author;
        this.category = category;
        this.length = length;
    }
}

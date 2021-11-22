package com.example.dataJPA.repositories;

import com.example.dataJPA.entities.Course;
import com.example.dataJPA.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial(){

        Course course = new Course("Math", 6);
        CourseMaterial courseMaterial = new CourseMaterial("www.google.com", course);
        repository.save(courseMaterial);
    }

    @Test
    public void printCourseMaterials(){
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("courseMaterials :" + courseMaterials);
    }

}
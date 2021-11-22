package com.example.dataJPA.repositories;

import com.example.dataJPA.entities.Course;
import com.example.dataJPA.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        //Course course1 = new Course("Physique", 4);

        //Course course2 = new Course("Informatique", 3);

        //Teacher teacher = new Teacher("Mahmoud", "Arouri", List.of(course1, course2));
        Teacher teacher = new Teacher("Mahmoud", "Arouri");
        teacherRepository.save(teacher);

    }

}
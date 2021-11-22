package com.example.dataJPA.repositories;

import com.example.dataJPA.entities.Course;
import com.example.dataJPA.entities.Guardian;
import com.example.dataJPA.entities.Student;
import com.example.dataJPA.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public  void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses :" + courses);
    }

//    @Test
//    public void saveCourseWithTeacher(){
//        //Teacher teacher = new Teacher("Marwen", "Arouri");
//        Teacher teacher2 = new Teacher("Amine", "Arouri");
//
//        //Course course = new Course("Geology", 2, teacher);
//        Course course2 = new Course("conception", 4, teacher2);
//
//
//        //courseRepository.save(course);
//        courseRepository.save(course2);
//    }

    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalElements();

        long totalPages =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }

    @Test
    public  void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));

        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending() );

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );

        List<Course> courses
                = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printfindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "M",
                        firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);

    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Guardian guardian4 = new Guardian("guardian4", "guardian4@gmail.com", "44444");

//        Teacher teacher = new Teacher("Ali", "Ben Romdhane");
        Teacher teacher = new Teacher("Ali", "Ben Romdhane");
        Student student = new Student("Ben Ahmed","Ahmed", "ahmed@gmail.com", guardian4);
        Course course = new Course("IA", 2, teacher, List.of(student));

        courseRepository.save(course);
    }
}
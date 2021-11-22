package com.example.dataJPA.repositories;

import com.example.dataJPA.entities.Guardian;
import com.example.dataJPA.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Guard;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian3 = new Guardian("guardian3", "guardian3@gmail.com", "33333");
        Student student = new Student("Arouri", "Amine", "amine@gmail.com", guardian3);
        studentRepository.save(student);
    }

    @Test
    public void findByLastName(){
        List<Student> students = studentRepository.findByLastName("Mahmoud");
        System.out.println("students :" + students);
    }

    @Test
    public void findByLastNameContaining(){
        List<Student> students = studentRepository.findByLastNameContaining("Mar");
        System.out.println("students :" + students);
    }

    @Test
    public void findByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("guardian1");
        System.out.println("students :" + students);
    }

    @Test
    public void getStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "mahmoud@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void getStudentLastNameByEmailAddress() {
        String lastName =
                studentRepository.getStudentLstNameByEmailAddress(
                        "marwen@gmail.com"
                );
        System.out.println("last name = " + lastName);
    }

    @Test
    public void getStudentByEmailAddressNative() {
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "mahmoud@gmail.com"
                );
        System.out.println("Student = " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "marwen@gmail.com"
                );
        System.out.println("Student = " + student);
    }


    @Test
    public void updateStudentNameByEmailId() {
                studentRepository.updateStudentNameByEmailId(
                        "mahmoud arouri",
                        "mahmoud@gmail.com"
                );
    }


}
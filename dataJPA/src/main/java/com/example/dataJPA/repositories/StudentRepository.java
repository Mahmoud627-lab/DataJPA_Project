package com.example.dataJPA.repositories;

import com.example.dataJPA.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByLastName(String lastName);

    public List<Student> findByLastNameContaining(String name);

    public List<Student> findByGuardianName(String guardianName);

    //public List<Student> findByLastnameAndFirstname(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL
    @Query("select s.lastName from Student s where s.emailId = ?1")
    String getStudentLstNameByEmailAddress(String emailId);

    //SQL NATIVE
    @Query(
            value = "select * from student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //SQL NATIVE Named PARAM
    @Query(
            value = "select * from student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    //@Modifying @Transactional
    @Modifying
    @Transactional
    @Query(
            value = "update student set last_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String lastName, String emailId);
}

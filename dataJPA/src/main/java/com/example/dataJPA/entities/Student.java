package com.example.dataJPA.entities;

import javax.persistence.*;


@Entity
@Table(
        name = "student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;



    public Student(Long studentId, String firstName, String lastName, String emailId, Guardian guardian) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.guardian = guardian;
        //this.guardianName = guardianName;
        //this.guardianEmail = guardianEmail;
        //this.guardianMobile = guardianMobile;
    }

    public Student(String firstName, String lastName, String emailId, Guardian guardian) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.guardian = guardian;
        //this.guardianName = guardianName;
        //this.guardianEmail = guardianEmail;
        //this.guardianMobile = guardianMobile;
    }

    public Student() {
    }

    public Student(String ben_ahmed, String ahmed, String s) {

    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }



    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                //", guardianName='" + guardianName + '\'' +
                //", guardianEmail='" + guardianEmail + '\'' +
                //", guardianMobile='" + guardianMobile + '\'' +
                '}';
    }
}

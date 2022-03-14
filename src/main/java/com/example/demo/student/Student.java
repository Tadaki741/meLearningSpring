package com.example.demo.student;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

/*
@Entity is for Hibernate
@Table is the use inside the database
@Transient is for column that does not need to be displayed in the database, we want to hide it away
 */

@Entity
@Table
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
    private long id;
    private String name;
    @Transient
    private Integer age;
    private LocalDate dob;
    private String email;


    //Constructor
    public Student(long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Student(){}

    //Use constructor without id as the database might generate id for us
    public Student(String name,String email,LocalDate dob) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

    //Setter, Getter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}

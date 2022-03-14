package com.example.demo.student;

/*
Repository is naming convention for anything that access to the database
 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Long data type is for the id of the student
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //Custom function to find user by email
    //SELECT * FROM student WHERE email = @param or...
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}

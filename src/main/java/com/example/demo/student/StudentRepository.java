package com.example.demo.student;

/*
Repository is naming convention for anything that access to the database
 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Long data type is for the id of the student
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {



}

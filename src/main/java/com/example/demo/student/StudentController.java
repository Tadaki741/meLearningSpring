package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
path is how the data is accessed on the url
 */

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    //Reference to student service
    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    /*
    Post mapping for taking the data from the client request, then map the data into the object Student
     */
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId")Long studentId,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String email){
        studentService.updateStudent(studentId,name,email);
    }



}

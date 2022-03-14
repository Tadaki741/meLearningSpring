package com.example.demo.student;

/*
@Component or @Service are same thing, but @Service are more semantic, increase readability
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        //return a list
        return studentRepository.findAll();
    }


    public void addNewStudent(Student student) {
        Optional<Student> studentOptional =  studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalCallerException("email taken !");
        }
        else{
            studentRepository.save(student);
        }
    }

    public void deleteStudent(long studentId) {

        boolean indicator = studentRepository.existsById(studentId);
        if(!indicator){
            throw new IllegalStateException("student with id: " + studentId + " does not exist");
        }
        else{
            studentRepository.deleteById(studentId);
        }

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with id: " + studentId + " does not exist"));

        //Else if the student does exist
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email has been taken !");

            }
            student.setEmail(email);
        }
    }
}

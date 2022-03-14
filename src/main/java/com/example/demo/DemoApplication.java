package com.example.demo;

/*
The @RestController annotation will make this class, DemoApplication become the class that serve endpoints
The current rest endpoint we are having is the hello() method
 */

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}


/*
@GetMapping
	public List<Student> hello(){
		return List.of(
				new Student(
						1L,
						"Mariam",
						"mariam.jamal@gmail.com",
						LocalDate.of(2000, Month.JANUARY,5),
						21
				)
		);
	}
 */

package com.example.demo;

/*
The @RestController annotation will make this class, DemoApplication become the class that serve endpoints
The current rest endpoint we are having is the hello() method
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}


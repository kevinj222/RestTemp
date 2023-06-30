package com.example.libraryx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LibraryxApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryxApplication.class, args);
	}

}

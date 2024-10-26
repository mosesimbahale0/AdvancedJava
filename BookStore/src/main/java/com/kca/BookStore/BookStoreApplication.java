package com.kca.BookStore;

import org.springframework.boot.SpringApplication;  // Importing SpringApplication to run the Spring Boot application
import org.springframework.boot.autoconfigure.SpringBootApplication;  // Importing SpringBootApplication annotation to enable auto-configuration

// @SpringBootApplication is a convenience annotation that adds @Configuration, @EnableAutoConfiguration, and @ComponentScan
@SpringBootApplication
public class BookStoreApplication {

	// The main method is the entry point of the Spring Boot application
	public static void main(String[] args) {
		// SpringApplication.run() method launches the application by starting the Spring framework and the embedded server
		SpringApplication.run(BookStoreApplication.class, args);
	}

}

//		@SpringBootApplication: This annotation enables several features:
//		@Configuration: Allows the class to define beans for dependency injection.
//		@EnableAutoConfiguration: Tells Spring Boot to automatically configure your application based on the dependencies you have.
//		@ComponentScan: Scans for Spring components (like services, controllers) in the package and its sub-packages.
//		SpringApplication.run(): This is the method that bootstraps the application, starting the Spring context and initializing the embedded Tomcat server (or other configured server). It runs the application using the BookStoreApplication class as the source.
//		This is the starting point of your Spring Boot application, where everything begins.
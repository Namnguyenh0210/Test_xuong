package com.example.projectend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Value;

/**
 * MAIN APPLICATION CLASS
 * Người 1 - Database Design & Backend Core
 */
@SpringBootApplication
public class ProjectendApplication implements CommandLineRunner {

    @Value("${server.port:8080}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(ProjectendApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Application is running at: http://localhost:" + port + "/");
    }

}

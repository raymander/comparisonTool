package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComparisonToolApplication {

    /**
     * The main method makes it possible to run the application as a plain Java
     * application which starts embedded web server via Spring Boot.
     *
     * @param args
     * command line parameters
     */

    public static void main(String[] args) {
        SpringApplication.run(ComparisonToolApplication.class, args);
    }

}

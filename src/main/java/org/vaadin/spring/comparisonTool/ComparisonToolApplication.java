package org.vaadin.spring.comparisonTool;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.vaadin.spring.comparisonTool.domain.DateData;
import org.vaadin.spring.comparisonTool.domain.DateDataRepository;

import java.util.ArrayList;

@SpringBootApplication
public class ComparisonToolApplication {

    /**
     * The main method makes it possible to run the application as a plain Java
     * application which starts embedded web server via Spring Boot.
     *
     * @param args
     * command line parameters
     */



    private final String FILE_PATH = "./src/main/resources/DATA.csv";

    public static void main(String[] args) {
        SpringApplication.run(ComparisonToolApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(DateDataRepository repository) {
        return (args) -> {
            ArrayList<DateData> dataList = new ArrayList<DateData>();
            dataList = CSVFileReader.readData(FILE_PATH);
            for (DateData d : dataList) {
                repository.save(d);
            }

	        System.out.println("fetch all data");
			for (DateData d : repository.findAll()) {
                System.out.println(d.toString());
			}
        };
    }
}

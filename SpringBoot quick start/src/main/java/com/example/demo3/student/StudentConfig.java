package com.example.demo3.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student nodirabegim = new Student(
                    "Nodirabegim",
                    "nea@gmail.com",
                    LocalDate.of(2000, 1, 28)
            );
            Student sardor = new Student(
                    "Sardor",
                    "sardor@gmail.com",
                    LocalDate.of(1998, 3, 17)
            );

            studentRepository.saveAll(List.of(nodirabegim,sardor));
        };
    }
}

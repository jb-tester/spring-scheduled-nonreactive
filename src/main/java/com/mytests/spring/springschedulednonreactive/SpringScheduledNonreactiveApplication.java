package com.mytests.spring.springschedulednonreactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringScheduledNonreactiveApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringScheduledNonreactiveApplication.class, args);
    }

}

package com.example.jpa_homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JpaHomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHomeworkApplication.class, args);
	}

}

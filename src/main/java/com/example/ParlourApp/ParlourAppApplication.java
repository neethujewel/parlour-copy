package com.example.ParlourApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages =  {"com.example.ParlourApp"})
public class  ParlourAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParlourAppApplication.class, args);
	}

}

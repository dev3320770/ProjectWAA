package com.mum;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.mum.storage.StorageProperties;

import com.mum.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ProjectWaaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWaaApplication.class, args);
	}

	   @Bean
	    CommandLineRunner init(StorageService storageService) {
	        return (args) -> {
	            storageService.deleteAll();
	            storageService.init();
	        };
	    }
	
}

package com.sprintOne.IPLFantasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(scanBasePackages = {"com.sprintOne"})
@EnableJpaRepositories("com.sprintOne.dao")
@EntityScan("com.sprintOne.model")
@EnableSwagger2
public class IplFantasyApplication {

	public static void main(String[] args) {
		SpringApplication.run(IplFantasyApplication.class, args);
		System.out.println("IPL Fantasy Application Started...");
	
	}

}

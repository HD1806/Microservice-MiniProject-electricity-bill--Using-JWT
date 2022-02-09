package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@PropertySource("classpath:Response.properties")
@EnableSwagger2
public class DemoElectricReaderAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoElectricReaderAuthApplication.class, args);
	}

}

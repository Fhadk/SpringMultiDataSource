package com.SpringMultiDataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringMultiDataSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMultiDataSourceApplication.class, args);
	}

}

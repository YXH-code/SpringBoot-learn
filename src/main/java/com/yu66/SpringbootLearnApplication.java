package com.yu66;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SpringbootLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLearnApplication.class, args);
	}

}

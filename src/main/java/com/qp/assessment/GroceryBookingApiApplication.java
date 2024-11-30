package com.qp.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.qp.assessment.model")  
public class GroceryBookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryBookingApiApplication.class, args);
	}

}

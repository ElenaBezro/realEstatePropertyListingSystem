package com.example.realEstatePropertyListingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.realEstatePropertyListingSystem.store.entities")
public class RealEstatePropertyListingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstatePropertyListingSystemApplication.class, args);
	}

}

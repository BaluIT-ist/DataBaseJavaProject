package com.dan.green_energy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GreenEnergyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenEnergyApiApplication.class, args);
	}

}

package com.yathriglobe.trip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class YathriGlobeTripServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(YathriGlobeTripServiceApplication.class, args);
	}

}

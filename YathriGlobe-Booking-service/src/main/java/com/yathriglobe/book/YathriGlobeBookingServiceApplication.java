package com.yathriglobe.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class YathriGlobeBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(YathriGlobeBookingServiceApplication.class, args);
	}

}

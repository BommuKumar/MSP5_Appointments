package com.naresh.Database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Msp4AppointmentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Msp4AppointmentAppApplication.class, args);




	}

}

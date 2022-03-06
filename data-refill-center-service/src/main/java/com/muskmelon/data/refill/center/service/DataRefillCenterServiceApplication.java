package com.muskmelon.data.refill.center.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class DataRefillCenterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataRefillCenterServiceApplication.class, args);
	}

}

package com.muskmelon.data.refill.center.activity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.muskmelon.data.refill.center.activity.mapper")
public class DataRefillCenterActivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataRefillCenterActivityApplication.class, args);
	}

}

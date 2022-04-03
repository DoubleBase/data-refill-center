package com.muskmelon.reliable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.muskmelon.reliable.mapper")
public class ReliableMessageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReliableMessageServiceApplication.class, args);
	}

}

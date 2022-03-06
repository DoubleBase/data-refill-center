package com.muskmelon.data.refill.center.credit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.muskmelon.data.refill.center.credit.mapper")
public class DataRefillCenterCreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataRefillCenterCreditApplication.class, args);
	}

}

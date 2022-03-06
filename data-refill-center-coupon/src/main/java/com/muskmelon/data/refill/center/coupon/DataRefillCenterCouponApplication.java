package com.muskmelon.data.refill.center.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.muskmelon.data.refill.center.coupon.mapper")
public class DataRefillCenterCouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataRefillCenterCouponApplication.class, args);
	}

}

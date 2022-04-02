package com.muskmelon.data.refill.center.lottery;

import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudSecondaryConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@Import(SpringCloudSecondaryConfiguration.class)
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.muskmelon.data.refill.center.lottery.mapper")
public class DataRefillCenterLotteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataRefillCenterLotteryApplication.class, args);
	}

}

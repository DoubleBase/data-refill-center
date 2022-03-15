package com.muskmelon.data.refill.center.finance;

import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudSecondaryConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@Import(SpringCloudSecondaryConfiguration.class)
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.muskmelon.data.refill.center.finance.mapper")
public class DataRefillCenterFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataRefillCenterFinanceApplication.class, args);
	}

}

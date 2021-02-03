package com.api.foodorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.api.foodorder.config.RibbonConfiguration;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "bankPayment", configuration = RibbonConfiguration.class)
public class FoodOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderApplication.class, args);
	}

}

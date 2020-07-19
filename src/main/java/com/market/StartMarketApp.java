package com.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.market"})
public class StartMarketApp {

	public static void main(String[] args) {
		SpringApplication.run(StartMarketApp.class, args);

	}

}

package com.qa.aprenable2.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public LocalTime timeBean() {
		return LocalTime.now();
	}
}

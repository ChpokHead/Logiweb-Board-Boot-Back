package com.chpok.logiwebboardboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

@SpringBootApplication
public class LogiwebBoardBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(LogiwebBoardBootApplication.class, args);
	}

	@Bean
	public StringJsonMessageConverter stringJsonMessageConverter() {
		return new StringJsonMessageConverter();
	}
}

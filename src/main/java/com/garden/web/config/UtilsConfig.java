package com.garden.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.garden.web.utils.UUIDGenerator;

@Configuration
public class UtilsConfig {
	
	@Bean
	public UUIDGenerator uuIDGenerator(){
		return new UUIDGenerator();
	}
	
}

package com.garden.web.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.garden.web.utils.PictureGenerator;
import com.garden.web.utils.UUIDGenerator;

@Configuration
public class UtilsConfig {
	
	@Bean
	public UUIDGenerator uuIDGenerator(){
		return new UUIDGenerator();
	}
	
	@Bean
	public PictureGenerator pictureGenerator() throws IOException{
		InputStream in = UtilsConfig.class.getClassLoader().getResourceAsStream("utlis-params.properties");
		Properties properties = new Properties();
		properties.load(in);
		return new PictureGenerator(properties.getProperty("hostUrl")
				,properties.getProperty("uploadUrl")
				,properties.getProperty("downloadUrl"));
	}
}

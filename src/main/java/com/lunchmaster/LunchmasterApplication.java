package com.lunchmaster;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@EnableScheduling
public class LunchmasterApplication {

	@Value("#{'${allowed.origins}'.split(',')}")
	private String[] allowedOrigins;

	@Value("#{'${allowed.methods}'.split(',')}")
	private String[] allowedMethods;

	public static void main(String[] args) {
		SpringApplication.run(LunchmasterApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping("/api/**").allowedOrigins(allowedOrigins).allowedMethods(allowedMethods);
				registry.addMapping("/registration").allowedOrigins(allowedOrigins).allowedMethods(allowedMethods);
			}
		};
	}
}

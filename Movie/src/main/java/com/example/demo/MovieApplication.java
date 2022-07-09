package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.controller.HomeController;

@SpringBootApplication
public class MovieApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    registry.addResourceHandler("/ext/**").addResourceLocations("file:///F:/");
		registry.addResourceHandler("/ext/**").addResourceLocations("file:///" + HomeController.drive);
	}
}

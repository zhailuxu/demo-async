package com.example.demo;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;

@Component
public class MyWebApplicationInitializer implements WebApplicationInitializer {

		@Override
		public void onStartup(ServletContext container) {
			System.out.println("----MyWebApplicationInitializer----");
		}
}

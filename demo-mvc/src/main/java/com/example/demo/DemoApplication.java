package com.example.demo;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.demo" })
@ServletComponentScan

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	// @Bean
	// public TomcatReactiveWebServerFactory servletContainer() {
	// TomcatReactiveWebServerFactory tomcat = new TomcatReactiveWebServerFactory();
	// tomcat.setProtocol("org.apache.coyote.http11.Http11Nio2Protocol");
	// return tomcat;
	// }
	 @Bean
	 public TomcatServletWebServerFactory servletContainer() {
	 TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
	 tomcat.setProtocol("org.apache.coyote.http11.Http11Nio2Protocol");
	 return tomcat;
	 }
}

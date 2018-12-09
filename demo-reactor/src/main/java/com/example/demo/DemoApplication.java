package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.demo" })

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
	// @Bean
	// public TomcatServletWebServerFactory servletContainer() {
	// TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
	// tomcat.setProtocol("org.apache.coyote.http11.Http11Nio2Protocol");
	// return tomcat;
	// }
}

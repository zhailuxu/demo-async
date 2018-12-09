package com.example.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.stereotype.Component;
@WebFilter(asyncSupported=true)
public class MyWebFilter implements Filter{

	public MyWebFilter() {
		System.out.println("----MyWebFilter----");

	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("----begin fitler----");
		chain.doFilter(request, response);
		System.out.println("----end fitler----");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

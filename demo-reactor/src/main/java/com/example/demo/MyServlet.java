//package com.example.demo;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.AsyncContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(urlPatterns = "/test", asyncSupported = true)
//public class MyServlet extends HttpServlet {
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		System.out.println("---begining serlvet----");
//		final AsyncContext asyncContext = req.startAsync();
//		asyncContext.start(new Runnable() {
//
//			@Override
//			public void run() {   
//				try {
//					System.out.println("---async res begin----");
//					Thread.sleep(10000);
//					resp.setContentType("text/html");
//					PrintWriter out = asyncContext.getResponse().getWriter();
//					out.println("<html>");
//					out.println("<head>");
//					out.println("<title>Hello World</title>");
//					out.println("</head>");
//					out.println("<body>");
//					out.println("<h1>welcome this is my servlet1!!!</h1>");
//					out.println("</body>");
//					out.println("</html>");
//					System.out.println("---async res end----");
//
//				} catch (Exception e) {
//					System.out.println(e.getLocalizedMessage());
//				} finally {
//					asyncContext.complete();
//				}
//			}
//		});
//
//		System.out.println("---end serlvet----");
//
//	}
//
//}

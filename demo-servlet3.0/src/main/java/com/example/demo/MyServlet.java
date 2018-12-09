package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test", asyncSupported = true)
public class MyServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("---begining serlvet----");
		String name = req.getParameter("name");
		System.out.println("name:"+name);
		
		 name = req.getParameter("nameget");
		System.out.println("name:"+name);
		
		final AsyncContext asyncContext = req.startAsync();
		asyncContext.start(new Runnable() {

			@Override
			public void run() {   
				try {
					System.out.println("---async res begin----");
					
					
					InputStream in = req.getInputStream();
					
					byte [] buf = new byte[1024];
					int bytes = in.read(buf);
					System.out.println(bytes + " " +(new String(buf)));;
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream()));
					String str = null;
					while((str = bufferedReader.readLine())!= null) {
						System.out.print("---" + str+"----");
					}
					
					Thread.sleep(10000);
					resp.setContentType("text/html");
					PrintWriter out = asyncContext.getResponse().getWriter();
					out.println("<html>");
					out.println("<head>");
					out.println("<title>Hello World</title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<h1>welcome this is my servlet1!!!</h1>");
					out.println("</body>");
					out.println("</html>");
					System.out.println("---async res end----");

				} catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
				} finally {
					asyncContext.complete();
				}
			}
		});

		System.out.println("---end serlvet----");

	}

}

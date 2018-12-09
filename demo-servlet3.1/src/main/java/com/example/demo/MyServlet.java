package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test", asyncSupported = true)
public class MyServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("---begining serlvet----");
		final AsyncContext asyncContext = req.startAsync();
		
		final ServletInputStream inputStream = req.getInputStream();
		inputStream.setReadListener(new ReadListener() {
			   
			@Override
			public void onError(Throwable throwable) {
				 System.out.println("onError thread: " + Thread.currentThread().getName());

			}
			
			@Override
			public void onDataAvailable() throws IOException {   
				 System.out.println("ReadListener thread: " + Thread.currentThread().getName());

			        try {
			          byte buffer[] = new byte[1 * 1024];
			          int readBytes = 0;
			          while (inputStream.isReady() && !inputStream.isFinished()) {
			            int length = inputStream.read(buffer);
			            if (length != -1) {
			         //     System.out.println("Read content: " + new String(buffer) + "");
			            }

			          }
			          
			          if ( inputStream.isFinished()) {
			           // 	asyncContext.complete();
			              System.out.println("Read: " + new String(buffer) + " bytes");
			              return;
			            }

			        } catch (IOException ex) {
						System.out.println(ex.getLocalizedMessage());

			        //  asyncContext.complete();
			        }
			}
			
			@Override
			public void onAllDataRead() throws IOException {
				try {
					System.out.println("---async res begin----");
					
					
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

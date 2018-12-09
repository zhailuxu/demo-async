package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TestHttpSend {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;

		try {
			// 1 发起链接
			socket = new Socket("127.0.0.1", 8080);
			// 2 转换socket输入流
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 3 转换socket输出流，并写入
			printWriter = new PrintWriter(socket.getOutputStream());
			//printWriter.write("GET /person?name=gh HTTP/1.0\r\n");//request.getQueryString()
			//printWriter.write("POST /person HTTP/1.0\r\n");//request.getParameter()仅在contentType是application/x-www-form-urlencoded时可以
			printWriter.write("POST /test HTTP/1.0\r\n");//request.getParameter()仅在contentType是application/x-www-form-urlencoded时可以
			printWriter.write("name:1\r\n");  
			  
			
			String content = "name=zlx&c=b";
			printWriter.write("Content-Length: " + content.length() + "\r\n");
			//https://blog.csdn.net/xybz1993/article/details/80655991
			//注意，在读取参数时候需要这个(这时候会读取body)，当读取流时候要关闭这个（这时候不会读取body）
			//requst.parseParameters
			//printWriter.write("Content-Type:application/x-www-form-urlencoded"+ "\r\n");

			printWriter.write("\r\n");
			printWriter.write(content);

			
			printWriter.flush();
			// 4 从socket读取
			String str = null;
			while((str = bufferedReader.readLine())!= null) {
				System.out.println("---" + str+"----");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5 关闭流和套接字
			if (null != bufferedReader) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (null != printWriter) {
				printWriter.close();
			}

			if (null != socket) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

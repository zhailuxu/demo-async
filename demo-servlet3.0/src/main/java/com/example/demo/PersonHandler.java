package com.example.demo;

import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class PersonHandler {

	@PostMapping("/person")
	String listtPost(@RequestParam(value = "name", required = true) String name) {
		
		System.out.println("----begin cotrllo----");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----end cotrllo----");

		return "hello:" +name;
	}

	@GetMapping("/person")
	Mono<String> list(@RequestParam(value = "name", required = true) String name) {

		System.out.println("----begin cotrllo----");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----end cotrllo----");

		return Mono.just("test"+name);
	}

	@PostMapping("/personPost")
	Mono<String> listPost() {

		System.out.println("----begin cotrllo----");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----end cotrllo----");

		return Mono.just("test");
	}

	@PostMapping("/personPostCallable")
	Callable<String> listPostCall() {

		System.out.println("----begin personPostCallable----");
		return new Callable<String>() {
			public String call() throws Exception {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("----end personPostCallable----");
				return "test";
			}
		};

	}

}
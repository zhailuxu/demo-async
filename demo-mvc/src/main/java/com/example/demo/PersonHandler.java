package com.example.demo;

import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class PersonHandler {

	@GetMapping("/person")
	Mono<String> list() {

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
//ReactiveTypeHandler
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

	//bio
	@PostMapping("/personPost2")
	String listPost2() {

		System.out.println("----begin cotrllo----");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----end cotrllo----");

		return "test";
	}

	@PostMapping("/personPostCallable")
	Callable<String> listPostCall() {

		System.out.println("----begin personPostCallable----");
		return new Callable<String>() {
			public String call() throws Exception {
				try {
					Thread.sleep(100000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("----end personPostCallable----");
				return "test";
			}
		};

	}

}
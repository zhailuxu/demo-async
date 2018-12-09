package com.example.demo;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

//
//,null,new Runnable() {
//	
//	@Override
//	public void run() {
//		System.out.println("--all send--");
//		
//	}
//},new Consumer< Subscription>() {
//
//	@Override
//	public void accept(Subscription t) {
//		System.out.println("--sub--" +t.toString());
//
//	}
//}

public class TestFlux {

	public static void main(String[] args) throws InterruptedException {

		
		Scheduler s = Schedulers.newParallel("parallel-scheduler", 4); 

		final Flux<String> flux = Flux
		    .range(1, 100)
		    .map(new Function<Integer, Integer>() {

				@Override
				public Integer apply(Integer t) {
					System.out.println(Thread.currentThread().getName() + " frist map" +t);
					return t +10;
				}
			})  
		    .subscribeOn(s)  
		    .map(new Function<Integer, String>() {

				@Override
				public String apply(Integer t) {
					System.out.println(Thread.currentThread().getName() + " second map" +t);
					return "value" + t;
				}
			});  

		new Thread(() -> flux.subscribe(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(Thread.currentThread().getName() + " next " +t);
				
			}
		})).start();;
		
//		Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);
//
//		final Flux<String> flux = Flux.range(1, 2).map(i -> 10 + i).publishOn(s).map(i -> "value " + i);
//
//		new Thread (new Runnable() {
//			
//			@Override
//			public void run() {
//				flux.subscribe(new Consumer<String>() {
//
//					@Override
//					public void accept(String t) {
//						System.out.println(Thread.currentThread().getName() + "  " + t);
//					}
//				});				
//			}
//		}).start();;
		

		// final Mono<String> mono = Mono.just("hello ");
		//
		// Thread thread = new Thread(() -> mono.map(msg -> msg + "thread ").subscribe(v
		// ->
		//
		// System.out.println(v + Thread.currentThread().getName())),"biz-thread");
		// thread.start();
		// thread.join();

		// Flux<String> flux = Flux.generate(() -> 0, (state, sink) -> {
		// sink.next("3 x " + state + " = " + 3 * state);
		// if (state == 10)
		// sink.complete();
		// return state + 1;
		// });
		//
		// flux.subscribe(i -> System.out.println(i));
		//
		// Flux<Integer> ints = Flux.range(1, 4);
		// ints.subscribe(i -> System.out.println(i), error -> System.err.println("Error
		// " + error),
		// () -> System.out.println("Done"), sub -> sub.request(2));

		// final Disposable disposable = Flux.interval(Duration.ofSeconds(0),
		// Duration.ofSeconds(2))
		// .subscribe(new Consumer<Long>() {
		//
		// @Override
		// public void accept(Long t) {
		// System.out.println("----" + t + "----");
		//
		// }
		// });

		// Flux<Integer> ints = Flux.range(1, 4);
		// ints.subscribe(i -> System.out.println(i), error -> System.err.println("Error
		// " + error),
		// () -> System.out.println("Done"));

		Thread.sleep(10000000);

	}

}

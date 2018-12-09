package com.example.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Consumer;
import java.util.stream.LongStream;

public class TestJDK9Flow {

	public static void main(String[] args) throws InterruptedException {
		//// test 1
		// SampleSubscriber<Boolean> sampleSubscriber = new SampleSubscriber<>(10, new
		// Consumer<Boolean>() {
		//
		// @Override
		// public void accept(Boolean t) {
		// System.out.println(t);
		//
		// }
		// });
		//
		// OneShotPublisher oneShotPublisher = new OneShotPublisher();
		// oneShotPublisher.subscribe(sampleSubscriber);

		//// test2
		SubmissionPublisher<Long> publisher = new SubmissionPublisher<>(); // 此处会把consumer包装成一个subscriber
		CompletableFuture<?> future = publisher.consume(System.out::println);
		LongStream.range(0, 1000).forEach(publisher::submit);


		// /////test3
		// SubmissionPublisher<Long> publisher = new SubmissionPublisher<>();
		// publisher.subscribe(new Subscriber<Long>() {
		//
		// @Override
		// public void onSubscribe(Subscription subscription) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void onNext(Long item) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void onError(Throwable throwable) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void onComplete() {
		// // TODO Auto-generated method stub
		//
		// }
		// });
		//

		Thread.sleep(10000);
	}

}

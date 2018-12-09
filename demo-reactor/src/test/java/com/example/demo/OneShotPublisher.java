package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class OneShotPublisher implements Publisher<Boolean> {
	private final ExecutorService executor = ForkJoinPool.commonPool(); // daemon-based
	private boolean subscribed; // true after first subscribe

	public synchronized void subscribe(Subscriber<? super Boolean> subscriber) {
		if (subscribed)
			subscriber.onError(new IllegalStateException()); // only one allowed
		else {
			subscribed = true;
			subscriber.onSubscribe(new OneShotSubscription(subscriber, executor));
		}
	}

	static class OneShotSubscription implements Subscription {
		private final Subscriber subscriber;
		private final ExecutorService executor;
		private Future future; // to allow cancellation
		private boolean completed;

		OneShotSubscription(Subscriber subscriber, ExecutorService executor) {
			this.subscriber = subscriber;
			this.executor = executor;
		}

		public synchronized void request(long n) {
			if (!completed) {
				//completed = true;
				if (n <= 0) {
					IllegalArgumentException ex = new IllegalArgumentException();
					executor.execute(() -> subscriber.onError(ex));
				} else {
					for(int i=0;i<n;++i)
					future = executor.submit(() -> {
						subscriber.onNext(Boolean.TRUE);
						subscriber.onComplete();
					});
				}
			}
		}

		public synchronized void cancel() {
			completed = true;
			if (future != null)
				future.cancel(false);
		}
	}
}
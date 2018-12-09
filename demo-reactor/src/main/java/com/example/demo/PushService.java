package com.example.demo;

import java.time.Duration;
import java.util.function.Function;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class PushService {

    public Flux<ServerSentEvent<Long>> create() {
        return Flux.interval(Duration.ofSeconds(1))
            .map(new Function<Long	, ServerSentEvent<Long>>() {

				@Override
				public ServerSentEvent<Long> apply(Long t) {
					// TODO Auto-generated method stub
					return ServerSentEvent.<Long>builder()
				            .event("hehe")
				            .data(t)
				            .build();
				}
			}).take(10);
    }

   
}

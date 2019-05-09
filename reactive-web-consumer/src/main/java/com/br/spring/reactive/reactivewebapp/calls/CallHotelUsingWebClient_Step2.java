package com.br.spring.reactive.reactivewebapp.calls;

import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import com.br.spring.reactive.reactivewebapp.Hotel;

public class CallHotelUsingWebClient_Step2 {

	private static final Logger logger = LoggerFactory.getLogger(CallHotelUsingWebClient_Step2.class);

	private static WebClient client = WebClient.create("http://localhost:8080");

	public static void main(String[] args) {

		Instant start = Instant.now();

		for (int i = 1; i <= 5; i++) {
			client.get().uri("/hotel/{id}", i).retrieve().bodyToMono(Hotel.class).subscribe();
		}

		logTime(start);
	}

	private static void logTime(Instant start) {
		logger.debug("Elapsed time: " + Duration.between(start, Instant.now()).toMillis() + "ms");
	}

}
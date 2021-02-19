package com.microserviceone.microserviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
// @EnableCircuitBreaker
public class MicroserviceOneApplication {
	
	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		
		//Timeout for recovering apiCall
//		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory
//			= new HttpComponentsClientHttpRequestFactory();
//		httpComponentsClientHttpRequestFactory.setConnectionRequestTimeout(3000);
//		return new RestTemplate(httpComponentsClientHttpRequestFactory);
		
		return new RestTemplate();
	}
	
	@Bean
	WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOneApplication.class, args);
	}

}

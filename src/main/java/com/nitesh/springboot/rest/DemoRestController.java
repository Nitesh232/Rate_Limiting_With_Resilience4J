package com.nitesh.springboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class DemoRestController {
	
	
	int count = 1;
	int fallcount = 1;
	
	@GetMapping("/msg")
	@RateLimiter(name = "messageService")
	public String getMessage() {
		System.out.println("Request count :: "+count);
		count++;
		return "Called message method...";
	}
	
	
	public String msgFallback(Exception e) {
		System.out.println("FallBack response count :: "+ fallcount);
		fallcount++;
		return "Called for message service";
	}
}

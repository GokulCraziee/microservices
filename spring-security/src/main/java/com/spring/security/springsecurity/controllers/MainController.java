package com.spring.security.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/")
	public String mainMethod() {
		return "<h1>Welcome</h1>";
	}
	
	@GetMapping("/user")
	public String userMethod() {
		return "<h1>Welcome user</h1>";
	}
	
	@GetMapping("/admin")
	public String adminMethod() {
		return "<h1>Welcome Admin</h1>";
	}
}

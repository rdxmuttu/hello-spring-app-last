package com.mysmartshop.authserver.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

	@GetMapping("/user")
	public String greetUser() {
		return "Hello User";
	}

	@GetMapping("/admin")
	public String greetAdmin() {
		return "Hello Admin";
	}

	@GetMapping("/message")
	public String greet() {
		return "Hello from Ust";
	}

}

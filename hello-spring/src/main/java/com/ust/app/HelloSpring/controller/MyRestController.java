package com.ust.app.HelloSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.app.HelloSpring.model.Customer;

@RestController
public class MyRestController {
	@GetMapping
	public String sayHello() {
		return "Hello World, welcome to spring boot";
	}

	@GetMapping("/greet/{username}")
	public String Greet(@PathVariable String username) {
		return "Good Afternoon " + username;
	}

	@GetMapping("/customer/{id}/{name}/{email}")
	public Customer getCustomer() {
		Customer c = new Customer(123, "VASU", "vasu@annan.com");
		return c;
	}

	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customer;
	}
}

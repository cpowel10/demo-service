package com.revature.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private Environment env;

	//localhost:8080/hello
	@GetMapping("/hello")
	public String sayHello() throws UnknownHostException {
		return String.format("Hello from %s:%s", InetAddress.getLocalHost().getHostAddress(), env.getProperty("local.server.port"));
	}

	@GetMapping("/bye")
	public String sayBye() throws UnknownHostException {
		return String.format("Bye from %s:%s", InetAddress.getLocalHost().getHostAddress(), env.getProperty("local.server.port"));
	}
}

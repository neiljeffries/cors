package com.example.restservicecors;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	// public class Fizzle{
	// 	private List<String> foo;
	// 	private boolean bar;
	// 	private int baz;
	// 	// getters and setters omitted
	// }

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();


	@GetMapping("/greeting-javaconfig")
	public ResponseEntity<Greeting> greetingWithJavaconfig(@RequestParam(required=false, defaultValue="World") String name) {
		return ResponseEntity.ok().body( new Greeting(counter.incrementAndGet(), String.format(template, name)) );
	}

	@RequestMapping(value = "/process",	method = RequestMethod.POST)
	public ResponseEntity<Object> process(@RequestBody Map<String, Object> payload) throws Exception {
	  return ResponseEntity.ok().body(payload);
	}

}

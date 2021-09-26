package com.example.greetingapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.greetingapp.model.Greeting;

@RestController
public class GreetingController {

	private static final String template="Hello %s";
	private final AtomicLong counter= new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam (value="name",defaultValue="world") String name) {
		
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
		
	}
	@RequestMapping(value= {"/query"},method=RequestMethod.GET)
	public String SayHello(@RequestParam (value="name",defaultValue="world") String name,@RequestParam(value="fName") String fName,@RequestParam(value="lName")String lName) {
		return new Greeting(counter.incrementAndGet(),String.format(template, name))+fName+" "+lName+"";
	
	}
}

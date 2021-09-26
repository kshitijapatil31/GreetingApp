package com.example.greetingapp.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.service.GreetingService;

@RestController
public class GreetingController {

	@Autowired
	public GreetingService greetingService;
	
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
	@RequestMapping(method=RequestMethod.POST,value="/addGreeting")
	public void addGretings(@RequestBody Greeting greeting) {
		greetingService.addGreeting(greeting);
		
		
	}
	
	@RequestMapping("/greeting/{id}")
	public Greeting findGretings(@PathVariable("id")long id) {
		return greetingService.findGreeting(id);
	}
	
	@RequestMapping("/getgreeting")
	public List<Greeting> allGreetings(){
		return greetingService.getAllreetings();
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/greeting/{id}")
	public void addGretings(@RequestBody Greeting greeting,@PathVariable("id")long id) {
		greetingService.editGreeting(greeting,id);
		
		
	}
}

package com.example.greetingapp.service;

import java.util.*;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.greetingapp.model.Greeting;

@Service
public class GreetingService {

	
	private List<Greeting> greetingList = new ArrayList<>(Arrays.asList(

            new Greeting( 1, "Hello"),
            new Greeting(2, "Hello from bridgelabz"),
            new Greeting( 3, "Hello bridgelabz")

    ));
	
	public void addGreeting(Greeting greeting) {
		greetingList.add(greeting);
	}
}

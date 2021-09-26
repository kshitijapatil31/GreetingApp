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

	public Greeting findGreeting(long id) {
		
		return greetingList.stream().filter(n->n.getId()==id).findFirst().get();
	}

	public List<Greeting> getAllreetings() {
		
		return greetingList;
	}

	public void editGreeting(Greeting greeting, long id) {
		int i=0;
		for(Greeting greetng1:greetingList) {
			if(greetng1.getId()==(id)) {
				greetingList.set(i, greeting);
			}
			i++;
		}
		
	}

	public void deleteGreeting(long id) {
		greetingList.removeIf(n->n.getId()==id);
		
	}
}

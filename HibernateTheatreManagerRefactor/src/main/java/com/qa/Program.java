package com.qa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Program implements CommandLineRunner {
	
	private static Program prog;
	@Autowired
	PerformerRepository performerRepository ;
	
	@Autowired
	TheatreGroupRepository theatreGroupRepository ;

	public static void main(String[] args) {
		SpringApplication.run(Program.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Here we go...");
		
	}
}

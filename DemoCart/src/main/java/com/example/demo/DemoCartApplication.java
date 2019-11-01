package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoCartApplication implements CommandLineRunner {

	private List<Product> prods = new ArrayList<>();
	private Customer c;

	@Autowired
	CustomerRepository custRep;

	@Autowired
	OrderRepository ordRep;
	
	@Autowired
	ProductRepository prodRep;

	public static void main(String[] args) {
		SpringApplication.run(DemoCartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		c = new Customer("Fred");
		custRep.save(c);
		custRep.save(new Customer("Bill"));
		custRep.save(new Customer("Mary"));

		prodRep.save(new Product("Printer", 99.99));
		prodRep.save(new Product("Screen", 49.99));
		prodRep.save(new Product("Desk", 125.00));
		prods = (List<Product>) prodRep.findAll() ;
		ordRep.save(new Order(LocalDate.now(), c, prods));

	}

}

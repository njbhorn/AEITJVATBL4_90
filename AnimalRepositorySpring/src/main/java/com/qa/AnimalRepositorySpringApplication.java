package com.qa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnimalRepositorySpringApplication implements CommandLineRunner {

	@Autowired
	AnimalRepository animalRepository ;

	@Autowired
	OwnerRepository ownerRepository ;

	public static void main(String[] args) {
		SpringApplication.run(AnimalRepositorySpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Owner o = new Owner(0, "Fred", "abc@xyz.com" ) ;
		Owner o2 = new Owner(1, "Mary", "xyz@qa.com") ;

		Animal a = new Animal ( 1, "Alpha", "Dog", getDate("10-01-2014"), o) ;
		Animal b = new Animal ( 1, "Beta", "Cat", getDate("10-06-2016"), o) ;
		Animal c = new Animal ( 1, "Charlie", "Dog", getDate("06-10-2013"), o) ;
		Animal d = new Animal ( 1, "Delta", "Rabbit", getDate("31-10-2014"), o) ;
		Animal e = new Animal ( 1, "Echo", "Cat", getDate("01-01-2017"), o) ;

		Animal f = new Animal ( 1, "Foxtrot", "Dog", getDate("23-02-2016"), o2) ;
		Animal g = new Animal ( 1, "Golf", "Hamster", getDate("09-06-2015"), o2) ;
		Animal h = new Animal ( 1, "Hotel", "Tiger", getDate("06-09-2014"), o2) ;
		Animal i = new Animal ( 1, "Indigo", "Dog", getDate("31-10-2011"), o2) ;
		Animal j = new Animal ( 1, "Juliet", "Cat", getDate("01-01-2012"), o2) ;

		Set<Animal> animals = new HashSet<Animal>() ;
		animals.add(a);
		animals.add(b);
		animals.add(c);
		animals.add(d);
		animals.add(e);

		o.setAnimals(animals);

		Set<Animal> animals2 = new HashSet<Animal>() ;
		animals2.add(f);
		animals2.add(g);
		animals2.add(h);
		animals2.add(i);
		animals2.add(j);

		o2.setAnimals(animals2);

		ownerRepository.save(o);
		ownerRepository.save(o2);
		animalRepository.save(a);
		animalRepository.save(b);
		animalRepository.save(c);
		animalRepository.save(d);
		animalRepository.save(e);
		animalRepository.save(f);
		animalRepository.save(g);
		animalRepository.save(h);
		animalRepository.save(i);
		animalRepository.save(j);


	}

	private static Date getDate(String dateString) throws IllegalArgumentException {
		Date parsed;
	      try {
	          SimpleDateFormat format =
	              new SimpleDateFormat("dd-MM-yyyy");
	          parsed = format.parse(dateString);
	      }
	      catch(ParseException pe) {
	          throw new IllegalArgumentException();
	      }
	      return parsed;
	}
}

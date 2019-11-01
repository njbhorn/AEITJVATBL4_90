package com.example.demo;

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
public class ExerciseAnimalRepositoryApplication implements CommandLineRunner{

	@Autowired
	OwnerRepository ownerRep ;
	
	@Autowired
	AnimalRepository animalRep ;
	
	public static void main(String[] args) {
		SpringApplication.run(ExerciseAnimalRepositoryApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Owner o = new Owner(0, "Fred", "abc@xyz.com" ) ;
		Owner o2 = new Owner(1, "Mary", "xyz@qa.com") ;
		
		ownerRep.save(o);
		ownerRep.save(o2);

		Animal a = new Animal (  "Alpha", "Dog", getDate("10-01-2014"), o) ;
		Animal b = new Animal (  "Beta", "Cat", getDate("10-06-2016"), o) ;
		Animal c = new Animal (  "Charlie", "Dog", getDate("06-10-2013"), o) ;
		Animal d = new Animal (  "Delta", "Rabbit", getDate("31-10-2014"), o) ;
		Animal e = new Animal (  "Echo", "Cat", getDate("01-01-2017"), o) ;

		Animal f = new Animal (  "Foxtrot", "Dog", getDate("23-02-2016"), o2) ;
		Animal g = new Animal (  "Golf", "Hamster", getDate("09-06-2015"), o2) ;
		Animal h = new Animal (  "Hotel", "Tiger", getDate("06-09-2014"), o2) ;
		Animal i = new Animal (  "Indigo", "Dog", getDate("31-10-2011"), o2) ;
		Animal j = new Animal (  "Juliet", "Cat", getDate("01-01-2012"), o2) ;

		animalRep.save(a);
		animalRep.save(b);
		animalRep.save(c);
		animalRep.save(d);
		animalRep.save(e);
		
		Set<Animal> animals = new HashSet<Animal>() ;
		animals.add(a);
		animals.add(b);
		animals.add(c);
		animals.add(d);
		animals.add(e);

		o.setAnimals(animals);
		
		animalRep.save(f);
		animalRep.save(g);
		animalRep.save(h);
		animalRep.save(i);
		animalRep.save(j);

		Set<Animal> animals2 = new HashSet<Animal>() ;
		animals2.add(f);
		animals2.add(g);
		animals2.add(h);
		animals2.add(i);
		animals2.add(j);

		o2.setAnimals(animals2);

		ownerRep.save(o);
		ownerRep.save(o2);

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

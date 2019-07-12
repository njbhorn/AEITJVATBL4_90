package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Program implements CommandLineRunner {

	private static SessionFactory factory ;

	@Autowired
	AnimalRepository animalRepository ;

	@Autowired
	OwnerRepository ownerRepository ;

	public static void main(String[] args) {

		SpringApplication.run(Program.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		try {
//			factory = new Configuration()
//				.configure()
//				.addAnnotatedClass(Animal.class)
//				.addAnnotatedClass(Owner.class)
//				.buildSessionFactory() ;
//		} catch ( Exception ex ) {
//			System.out.println(ex.getMessage());
//		}
//
//		try {
//			Session session = factory.openSession() ;
//			Transaction tx = null ;
//
//			tx = session.beginTransaction() ;

			Owner o = new Owner("Fred", "abc@xyz.com" ) ;
			System.out.println(o);

			ownerRepository.save(o);

//			tx.commit();
//
//			tx = session.beginTransaction() ;

			Animal a1 = new Animal() ;
			a1.setName("Rex");
			a1.setType("Dog");
			a1.setOwner(o) ;

			System.out.println(a1);

			Animal a2 = new Animal() ;
			a2.setName("Tibby");
			a2.setType("Cat");
			a2.setOwner(o) ;

			System.out.println(a2);

			List<Animal> animals = new ArrayList<>();
			animals.add(a1);
			animals.add(a2);

			o.setAnimals(animals);
			ownerRepository.save(o);

			animalRepository.save(a1);
			animalRepository.save(a2);

			List<Owner> owners = ownerRepository.findAll() ;
			List<Animal> owners_animals = animalRepository.findAll() ;

			System.out.println(owners);
			System.out.println(owners_animals);
			
//			tx.commit();
//		} catch ( HibernateException ex ) {
//
//		}


	}

}

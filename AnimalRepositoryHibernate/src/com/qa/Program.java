package com.qa;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Program {

	private static SessionFactory factory ;

	public static void main(String[] args) {
		try {
			factory = new Configuration()
				.configure()
				.addAnnotatedClass(Animal.class)
				.addAnnotatedClass(Owner.class)
				.buildSessionFactory() ;
		} catch ( Exception ex ) {
			System.out.println(ex.getMessage());
		}

		try {
			Session session = factory.openSession() ;
			Transaction tx = null ;

			tx = session.beginTransaction() ;

			Owner o = new Owner("Fred", "abc@xyz.com" ) ;
			System.out.println(o);

			session.save(o);

			tx.commit();

			tx = session.beginTransaction() ;

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
			session.save(o);

			session.save(a1);
			session.save(a2);
			tx.commit();
		} catch ( HibernateException ex ) {

		}

	}

}

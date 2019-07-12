package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJdbcSpringApplication implements CommandLineRunner{

	@Autowired
	PersonRepository personRepository ;

	@Autowired
	SkillRepository skillRepository ;

	public static void main(String[] args) {
		SpringApplication.run(DemoJdbcSpringApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("here we go...");

		List<Person> people = personRepository.findAll() ;
		System.out.println(people);

		Skill knitting = new Skill ("Knitting") ;
		Skill fencing = new Skill ("Fencing") ;
		skillRepository.save(knitting);
		skillRepository.save(fencing);

		Person p = new Person (  "fred") ;
		Person p2 = new Person (  "anne") ;
		Person p3 = new Person ( "bill") ;

		personRepository.save(p);
		personRepository.save(p2);
		personRepository.save(p3);
		people = personRepository.findAll() ;
		System.out.println(people);
		p.setName("freddie");
		personRepository.save(p) ;

		ArrayList<Skill> skills = new ArrayList<>();
		skills.add(knitting) ;
		skills.add(fencing);

		p.setSkills(skills);
		personRepository.save(p) ;


		p2.setSkills(skills);
		personRepository.save(p2);

//		skills.remove(0);
//		p3.setSkills(skills);
//		personRepository.save(p3);

	}


}

package com.qa.AnimalRepository;

import java.util.List;
import java.util.Set;

public class Owner {

	private int id ;
	private String name ;
	private String email ;
	private Set<Animal> animals ;

	public Owner() {

	}

	public Owner(int id, String name, String email) {
		this.id = id ;
		this.name = name;
		this.email = email;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", email=" + email + ", animals=" + animals + "]";
	}

}

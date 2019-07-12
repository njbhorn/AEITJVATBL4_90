package com.qa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Owner {

	private static int next_id ;

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id ;
	private String name ;
	private String email ;
	@OneToMany(mappedBy="animal_id")
	private List<Animal> animals ;

	public Owner() {
//		this.id = ++next_id;
	}

	public Owner(String name, String email) {
		this();
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

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", email=" + email + ", animals=" + animals + "]";
	}






}

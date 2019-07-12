package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String name ;


	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="personskill", joinColumns = @JoinColumn(name="person_id")
				, inverseJoinColumns = @JoinColumn(name = "skill_id")
					)
	private List<Skill> skills ;

	public Person() {

	}


	public Person(String name) {
		this.skills = new ArrayList<Skill>();
		this.name = name;
	}



	public List<Skill> getSkills() {
		return skills;
	}


	public void setSkills(List<Skill> skills) {
		this.skills = skills;
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

	@Override
	public String toString() {
		return "Person " + id + ", " + name ;
	}




}

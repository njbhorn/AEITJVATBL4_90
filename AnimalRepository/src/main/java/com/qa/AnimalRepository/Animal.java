package com.qa.AnimalRepository;

import java.util.Date;

public class Animal {

	private int id;
	private String name;

	public Animal(int id, String name, String type, Date dob, Owner owner) {

		this.id = id;
		this.name = name;
		this.type = type;
		this.dob = dob;
		this.owner = owner;
	}

	private String type;
	private Date dob;
	private Owner owner ;

	public Animal() {

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public int getOwner() {
//		return owner;
//	}
//
//	public void setOwner(int owner) {
//		this.owner = owner;
//	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}



	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}


	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", type=" + type + ", dob=" + dob + ", owner=" + owner
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getType()=" + getType() + ", getOwner()="
				+ getOwner() + ", getDob()=" + getDob() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}



}

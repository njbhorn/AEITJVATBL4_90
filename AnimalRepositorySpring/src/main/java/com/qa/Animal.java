package com.qa ;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int animalID;
	private String name;
	private String type;
	private Date dob;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private int ownerID ;
	private Owner owner ;

	public Animal() {

	}

	public Animal(int id, String name, String type, Date dob) {

		this.animalID = id;
		this.name = name;
		this.type = type;
		this.dob = dob;
	}

	public Animal(int id, String name, String type, Date dob, Owner owner) {

		this.animalID = id;
		this.name = name;
		this.type = type;
		this.dob = dob;
		this.ownerID = owner.getId();
	}

	public int getAnimalID() {
		return animalID;
	}

	public void setAnimalID(int id) {
		this.animalID = id;
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



	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

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
		return "Animal [id=" + animalID + ", name=" + name + ", type=" + type + ", dob=" + dob + ", owner=" + ownerID
				+ ", getId()=" + getAnimalID() + ", getName()=" + getName() + ", getType()=" + getType() + ", getOwner()="
				+ getOwner() + ", getDob()=" + getDob() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}



}

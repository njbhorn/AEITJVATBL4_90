package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Animal {

	private static int next_id ;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int animal_id;
	private String name;
	private String type;
//	private Date dob;
	@OneToOne
	@JoinColumn(name="id")
	private Owner owner ;

	public Animal() {
//		this.animal_id = ++next_id ;
	}

	public int getId() {
		return animal_id;
	}

	public void setId(int id) {
		this.animal_id = id;
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

//	public Date getDob() {
//		return dob;
//	}
//
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}

	@Override
	public String toString() {
		return "Animal [animal_id=" + animal_id + ", name=" + name + ", type=" + type + ", owner=" + owner + "]";
	}

}

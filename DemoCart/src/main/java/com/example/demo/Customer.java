package com.example.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custId ;
	
	private String name ;
	
	@OneToMany ( mappedBy = "customer")
	private List<Order> orders ;
	
	public Customer() {
		
	}
	
	public Customer(String name) {
		this.name = name ;
	}
	
	public int getId() {
		return custId;
	}
	public void setId(int id) {
		this.custId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	

}

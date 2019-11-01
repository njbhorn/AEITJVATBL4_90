package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_table")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	
	private LocalDate ordDate ;
	
	@ManyToOne
//	@JoinColumn ( name = "custId")
	private Customer customer ;
	
	@OneToMany
	private List<Product> products ;
	
	public Order() {
		
	}

	public Order(LocalDate ordDate, Customer customer, List<Product> prods) {
		this.ordDate = ordDate;
		this.customer = customer;
		this.products = prods;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getLd() {
		return ordDate;
	}
	public void setLd(LocalDate ld) {
		this.ordDate = ld;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}

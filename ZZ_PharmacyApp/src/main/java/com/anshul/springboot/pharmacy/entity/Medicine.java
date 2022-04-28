package com.anshul.springboot.pharmacy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {

	//FIELDS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String descripton;
	
	@Column(name="price")
	private double price;
	
	@Column(name="available")
	private int available;
	
	// CONSTRUCTORS
	public Medicine() {
		
	}

	public Medicine(int id, String name, String descripton, double price, int available) {
		super();
		this.id = id;
		this.name = name;
		this.descripton = descripton;
		this.price = price;
		this.available = available;
	}

	
	// GETTERS SETTERS AND TOSTRING
	
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

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	
	//ToString method
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", descripton=" + descripton + ", price=" + price
				+ ", available=" + available + "]";
	}

	

	
}












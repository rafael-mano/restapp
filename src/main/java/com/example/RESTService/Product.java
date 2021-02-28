package com.example.RESTService;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private long id;
	private String name;
	private BigDecimal price;
	private Date creationDate;
	
	public Product(long id, String name, BigDecimal price, Date creationDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.creationDate = creationDate;
	}
	
	public Product() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
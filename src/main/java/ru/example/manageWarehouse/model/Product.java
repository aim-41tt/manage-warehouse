package ru.example.manageWarehouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @Column(name = "productName")
    private String productName;
	 
	 @Column(name = "price")
    private double price;
	 	 
	 @Column(name="typeId")
	private Long typeId;
	 
	 @Column(name="kol")
	private Long kol;
	 
	 	 
    public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Product () {}
        
	public Product(String productName, double price, Long typeId , Long kol) {
		this.productName = productName;
		this.price = price;
		this.typeId = typeId;
		this.kol = kol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getKol() {
		return kol;
	}

	public void setKol(Long kol) {
		this.kol = kol;
	}

	  
    
}
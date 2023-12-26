package com.example.store.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("CUSTOMER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer extends User {
    private String des;

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	} 
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
    private List<Feedback> feedbacks =new ArrayList<>();
	
	@JsonIgnore
	 @OneToMany(mappedBy = "customer")
	 private List<Cart> carts=new ArrayList<>();
	@JsonIgnore
	 @OneToMany(mappedBy = "customer")
	 private List<Order> Orders=new ArrayList<>();
    // Constructors, getters, setters, etc.

	 
	 
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public List<Order> getOrders() {
		return Orders;
	}

	public void setOrders(List<Order> Orders) {
		this.Orders = Orders;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
    
	 
	 
}
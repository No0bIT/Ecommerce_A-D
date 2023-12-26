
package com.example.store.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.FilterJoinTable;

import com.example.store.DAO.CartDAO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 
	private int totalAmount;
	private LocalDate dateCreate;
	private String status;  
	
	 @OneToOne
	 @JoinColumn(name = "shipment_id")
	 private Shipment shipment;
	 
	 @OneToOne
	 @JoinColumn(name = "payment_id")
	 private Payment payment;
	 
	    
	 @OneToMany(mappedBy = "order")
	 @JsonIgnore
	 private List<Cart> carts =new ArrayList<>();
	  
	 @ManyToOne
	 @JoinColumn(name = "customer_id")
	 @JsonBackReference
	 private Customer customer;
	 
	public Customer getCustomer() {
		return customer;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<Cart> getCarts() {
		return carts;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(LocalDate dateCreate) {
		this.dateCreate = dateCreate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}




	 
}
package com.example.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("CLOTHES")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Clothes extends Product {
    private String type;
    private String color;

    @ManyToOne
    @JoinColumn(name = "producerClothes_id")
    private ProducerClothes producerClothes;
    
    
    @ManyToOne
    @JoinColumn(name = "brand_clothes_id")
    private BrandClothes brandClothes;
    // Constructors, getters, setters, etc.


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public ProducerClothes getProducerClothes() {
		return producerClothes;
	}


	public void setProducerClothes(ProducerClothes producerClothes) {
		this.producerClothes = producerClothes;
	}


	public BrandClothes getBrandClothes() {
		return brandClothes;
	}


	public void setBrandClothes(BrandClothes brandClothes) {
		this.brandClothes = brandClothes;
	}
    
}
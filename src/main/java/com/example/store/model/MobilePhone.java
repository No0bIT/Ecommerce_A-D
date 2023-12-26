package com.example.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("MOBILE_PHONE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MobilePhone extends Product {
    private String type;
    private String camera;
    private String screen;
    private String charger;
    private String speaker;

    
    @ManyToOne
    @JoinColumn(name = "producerMobilePhone_id")
    private ProducerMobilePhone producerMobilePhone;
    
    
    @ManyToOne
    @JoinColumn(name = "brand_mobile_phone_id")
    private BrandMobilePhone brandMobilePhone;
    // Constructors, getters, setters, etc.


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCamera() {
		return camera;
	}


	public void setCamera(String camera) {
		this.camera = camera;
	}


	public String getScreen() {
		return screen;
	}


	public void setScreen(String screen) {
		this.screen = screen;
	}


	public String getCharger() {
		return charger;
	}


	public void setCharger(String charger) {
		this.charger = charger;
	}


	public String getSpeaker() {
		return speaker;
	}


	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}


	public ProducerMobilePhone getProducerMobilePhone() {
		return producerMobilePhone;
	}


	public void setProducerMobilePhone(ProducerMobilePhone producerMobilePhone) {
		this.producerMobilePhone = producerMobilePhone;
	}


	public BrandMobilePhone getBrandMobilePhone() {
		return brandMobilePhone;
	}


	public void setBrandMobilePhone(BrandMobilePhone brandMobilePhone) {
		this.brandMobilePhone = brandMobilePhone;
	}
    
    
}
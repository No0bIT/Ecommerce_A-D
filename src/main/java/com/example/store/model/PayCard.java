package com.example.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DiscriminatorValue("PAYCARD")
public class PayCard extends Payment {
    private String des;
    private String bank;
    private String numCard;
    private String codeSecurity;
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	} 
	public String getNumCard() {
		return numCard;
	}
	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}
	public String getCodeSecurity() {
		return codeSecurity;
	}
	public void setCodeSecurity(String codeSecurity) {
		this.codeSecurity = codeSecurity;
	}
	

    // Constructors, getters, setters, v.v.
    
}

package com.example.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.PayCard;

public interface PayCardDAO extends JpaRepository<PayCard, Integer> {

}

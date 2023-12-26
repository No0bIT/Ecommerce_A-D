package com.example.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.Payment;

public interface PaymentDAO extends JpaRepository<Payment, Integer> {

}

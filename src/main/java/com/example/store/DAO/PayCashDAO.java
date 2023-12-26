package com.example.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.PayCash;

public interface PayCashDAO extends JpaRepository<PayCash, Integer> {

}

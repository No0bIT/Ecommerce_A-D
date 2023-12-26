package com.example.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {

}

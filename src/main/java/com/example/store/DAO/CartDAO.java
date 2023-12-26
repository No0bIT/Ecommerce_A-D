package com.example.store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.store.model.Cart;
import com.example.store.model.Customer;

public interface CartDAO extends JpaRepository<Cart, Integer> {
	List<Cart> findByCustomer_Id(int customer_id);
}

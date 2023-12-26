package com.example.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.Address;

public interface AddressDAO extends JpaRepository<Address, Integer> {

}

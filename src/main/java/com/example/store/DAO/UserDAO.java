package com.example.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.User;

public interface UserDAO extends JpaRepository<User, Integer> {

}

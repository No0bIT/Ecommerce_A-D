package com.example.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.Admin;

public interface AdminDAO extends JpaRepository<Admin, Integer> {

}

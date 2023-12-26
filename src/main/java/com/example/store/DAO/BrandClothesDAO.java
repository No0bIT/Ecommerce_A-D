package com.example.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.BrandClothes;

public interface BrandClothesDAO extends JpaRepository<BrandClothes, Integer> {

}

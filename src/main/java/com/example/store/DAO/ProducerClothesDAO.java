package com.example.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.ProducerClothes;

public interface ProducerClothesDAO extends JpaRepository<ProducerClothes, Integer> {

}

package com.example.store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.store.model.Clothes;

public interface ClothesDAO extends JpaRepository<Clothes, Integer> {
	@Query("SELECT c FROM Clothes c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Clothes> searchClothesByName(@Param("keyword") String keyword);
}

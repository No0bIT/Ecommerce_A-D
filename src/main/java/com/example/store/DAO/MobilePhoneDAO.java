package com.example.store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.store.model.MobilePhone;

public interface MobilePhoneDAO extends JpaRepository<MobilePhone, Integer>{
	@Query("SELECT m FROM MobilePhone m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<MobilePhone> searchMobilePhoneByName(@Param("keyword") String keyword);
}

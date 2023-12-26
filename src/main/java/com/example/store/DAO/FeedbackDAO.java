package com.example.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.Feedback;

public interface FeedbackDAO extends JpaRepository<Feedback, Integer> {

}

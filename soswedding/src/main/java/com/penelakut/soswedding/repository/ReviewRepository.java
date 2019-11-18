package com.penelakut.soswedding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.penelakut.soswedding.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByReviewedUserId(Long userId);
    List<Review> findAllByReviewerId(Long userId);
}

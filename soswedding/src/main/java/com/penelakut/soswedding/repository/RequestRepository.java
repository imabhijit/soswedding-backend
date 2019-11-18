package com.penelakut.soswedding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.penelakut.soswedding.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findAllByUserId(Long userId);
}

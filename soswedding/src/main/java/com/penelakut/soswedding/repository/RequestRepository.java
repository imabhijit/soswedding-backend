package com.penelakut.soswedding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.penelakut.soswedding.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
}

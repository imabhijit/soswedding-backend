package com.penelakut.soswedding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.penelakut.soswedding.model.ProviderService;

@Repository
public interface ProviderServiceRepository extends JpaRepository<ProviderService, Long> {
}

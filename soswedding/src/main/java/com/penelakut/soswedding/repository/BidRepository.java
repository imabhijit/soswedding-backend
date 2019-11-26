package com.penelakut.soswedding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.penelakut.soswedding.model.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findAllByRequestId(Long requestId);
    List<Bid> findAllByProviderUuid(String uuid);
}

package com.penelakut.soswedding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.penelakut.soswedding.model.Bid;
import com.penelakut.soswedding.repository.BidRepository;

@RunWith(MockitoJUnitRunner.class)
public class BidAPITest {

	public BidAPITest() {}

	@Mock
	BidRepository repository;

	@Test
	public void getBidByRequestId() {
		List<Bid> mockList= new ArrayList<Bid>();
		assertEquals(repository.findAllByRequestId(any()), mockList);
	}

	@Test
	public void getBidByProviderUuid() {
		List<Bid> mockList= new ArrayList<Bid>();
		assertEquals(repository.findAllByProviderUuid(any()), mockList);
	}

	@Test
	public void getBidByCoupleUuid() {
		List<Bid> mockList= new ArrayList<Bid>();
		assertEquals(repository.findAllByCoupleUuid(any()), mockList);
	}

}

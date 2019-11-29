package com.penelakut.soswedding;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.penelakut.soswedding.controller.BidAPI;
import com.penelakut.soswedding.model.Bid;
import com.penelakut.soswedding.repository.BidRepository;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BidAPITest {

	public BidAPITest() {}

	@InjectMocks
	BidAPI bidAPI;

	@Mock
	BidRepository bidRepository;

	@Mock
	Bid mockBid;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mockBid = new Bid();
        mockBid.setId(321L);
		mockBid.setAmount(123.5);
		mockBid.setMessage("Testing");
		mockBid.setProviderUuid("252");
		mockBid.setCoupleUuid("149");
        
		when(bidRepository.findById(any())).thenReturn(Optional.of(mockBid));
		when(bidRepository.findAllByProviderUuid(any())).thenReturn(List.of(mockBid));
		when(bidRepository.findAllByCoupleUuid(any())).thenReturn(List.of(mockBid));
	}

	@Test
	public void getBidById() {
		System.out.println("\tRunning getBidByID Test...\n");
		Bid bid = bidAPI.getBidById(mockBid.getId().toString());
		assertEquals(bid.getId(), mockBid.getId());
		verify(bidRepository).findById(any());
	}
	
	@Test
	public void getAllBidsByProviderUuid() {
		System.out.println("\tRunning getAllBidsByProviderUuid Test...\n");
		List<Bid> bids = bidAPI.getAllBidsByProviderUuid(mockBid.getProviderUuid());
		assertEquals(bids.get(0).getProviderUuid(), mockBid.getProviderUuid());
		verify(bidRepository).findAllByProviderUuid(any());
	}

	@Test
	public void getAllBidsByCoupleUuid() {
		System.out.println("\tRunning getAllBidsByCoupleUuid Test...\n");
		List<Bid> bids = bidAPI.getAllBidsByCoupleUuid(mockBid.getCoupleUuid());
		assertEquals(bids.get(0).getCoupleUuid(), mockBid.getCoupleUuid());
		verify(bidRepository).findAllByCoupleUuid(any());
	}

}

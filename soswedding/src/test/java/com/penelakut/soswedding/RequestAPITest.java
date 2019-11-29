package com.penelakut.soswedding;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.penelakut.soswedding.controller.RequestAPI;
import com.penelakut.soswedding.model.Request;
import com.penelakut.soswedding.repository.RequestRepository;

@RunWith(MockitoJUnitRunner.class)
public class RequestAPITest {

	public RequestAPITest() {}

	@InjectMocks
	RequestAPI requestAPI;

	@Mock
	RequestRepository requestRepository;

	@Mock
	Request mockRequest;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mockRequest = new Request();
		mockRequest.setId(2L);
		mockRequest.setCoupleUuid("48");
		mockRequest.setBudget(1200.3);
		mockRequest.setTitle("Test Req");
        
		when(requestRepository.findById(any())).thenReturn(Optional.of(mockRequest));
		when(requestRepository.findAllByCoupleUuid(any())).thenReturn(List.of(mockRequest));
	}

	@Test
	public void getRequestById() {
		System.out.println("\tRunning getRequestById Test...\n");
		Request request = requestAPI.getRequestById(mockRequest.getId().toString());
		assertEquals(request.getId(), mockRequest.getId());
		verify(requestRepository).findById(any());
	}
	
	@Test
	public void getAllRequestsByUserUuid() {
		System.out.println("\tRunning getAllRequestsByUserUuid Test...\n");
		List<Request> request = requestAPI.getAllRequestsByUserUuid(mockRequest.getCoupleUuid());
		assertEquals(request.get(0).getCoupleUuid(), mockRequest.getCoupleUuid());
		verify(requestRepository).findAllByCoupleUuid(any());
	}
}

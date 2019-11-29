package com.penelakut.soswedding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import java.util.ArrayList;
import java.util.List;
import com.penelakut.soswedding.model.Request;
import com.penelakut.soswedding.repository.RequestRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RequestTest {

	public RequestTest() {}

	@Mock
	RequestRepository repository;
	
	@Test
	public void getRequestByCoupleUuid() {
		List<Request> mockList= new ArrayList<Request>();
		assertEquals(repository.findAllByCoupleUuid(any()), mockList);
	}
	
}

package com.penelakut.soswedding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import java.util.ArrayList;
import java.util.List;

import com.penelakut.soswedding.model.Review;
import com.penelakut.soswedding.repository.ReviewRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReviewTest {

	public ReviewTest() {}

	@Mock
	ReviewRepository repository;
	
	@Test
	public void getReviewByUserId() {
		List<Review> mockList= new ArrayList<Review>();
		assertEquals(repository.findAllByReviewedUserId(any()), mockList);
    }
    
    @Test
	public void getReviewByReviewerId() {
		List<Review> mockList= new ArrayList<Review>();
		assertEquals(repository.findAllByReviewerId(any()), mockList);
	}
	
}

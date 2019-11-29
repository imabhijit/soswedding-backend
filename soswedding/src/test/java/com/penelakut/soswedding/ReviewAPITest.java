package com.penelakut.soswedding;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.penelakut.soswedding.controller.ReviewAPI;
import com.penelakut.soswedding.model.Review;
import com.penelakut.soswedding.repository.ReviewRepository;

@RunWith(MockitoJUnitRunner.class)
public class ReviewAPITest {

	public ReviewAPITest() {}

	@InjectMocks
	ReviewAPI reviewAPI;

	@Mock
	ReviewRepository reviewRepository;

	@Mock
	Review mockReview;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mockReview = new Review();
		mockReview.setId(2L);
        mockReview.setRating(5);
        mockReview.setDescription("Very good test case!");
        
        when(reviewRepository.findById(any())).thenReturn(Optional.of(mockReview));
        when(reviewRepository.findAllByReviewerId(any())).thenReturn(List.of(mockReview));
	}

	@Test
	public void getReviewById() {
		System.out.println("\tRunning getReviewById Test...\n");
		Review request = reviewAPI.getReviewById(mockReview.getId().toString());
		assertEquals(request.getId(), mockReview.getId());
		verify(reviewRepository).findById(any());
    }

    @Test
    public void getAllReviewByUserId() {
		System.out.println("\tRunning getAllReviewByUserId Test...\n");
        List<Review> request = reviewAPI.getAllReviewsByUserId(mockReview.getId().toString());
		assertEquals(request.get(0).getId(), mockReview.getId());
		verify(reviewRepository).findAllByReviewerId(any());
    }
}

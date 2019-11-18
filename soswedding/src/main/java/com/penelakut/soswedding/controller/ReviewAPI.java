package com.penelakut.soswedding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.penelakut.soswedding.model.Review;
import com.penelakut.soswedding.repository.ReviewRepository;

@RestController
public class ReviewAPI {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping("/review")
    public Review createReview(@RequestBody Review review){
        return reviewRepository.save(review);
    }

//    TODO: when join exists to user.
//    @GetMapping("/review/user/{id}")
//    public List<Review> getAllByUserId(@PathVariable String id){
//        return  reviewRepository.findAllByUserId(id);
//    }

    @GetMapping("/review/{id}")
    public Review getReviewById(@PathVariable String id){
        return reviewRepository.findById(Long.parseLong(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("No review found with id %s ", id)));
    }

    @PatchMapping("/review")
    public Review updateReview(@RequestBody Review review){
        return reviewRepository.save(review);
    }

    @DeleteMapping("/review")
    public void deleteReview(@RequestBody Review review){ reviewRepository.delete(review); }
}

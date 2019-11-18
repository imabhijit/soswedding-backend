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

import com.penelakut.soswedding.model.Request;
import com.penelakut.soswedding.repository.BidRepository;
import com.penelakut.soswedding.repository.RequestRepository;

@RestController
public class RequestAPI {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private BidRepository bidRepository;

    @PostMapping("/request")
    public Request createRequest(@RequestBody Request request){
        return requestRepository.save(request);
    }

//    TODO: when join exists to user.
//    @GetMapping("/request/user/{id}")
//    public List<Request> getAllByUserId(@PathVariable String id){
//        return  requestRepository.findAllByUserId(id);
//    }

//    TODO: when join exists to bid.
//    @GetMapping("/request/{id}/bid")
//    public List<Bid> getAllBidsById(@PathVariable String id){
//        return  bidRepository.findAllByRequestId(id);
//    }

    @GetMapping("/request/{id}")
    public Request getRequestById(@PathVariable String id){
        return requestRepository.findById(Long.parseLong(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("No service request found with id %s ", id)));
    }

    @PatchMapping("/request")
    public Request updateRequest(@RequestBody Request request){
        return requestRepository.save(request);
    }

    @DeleteMapping("/request")
    public void deleteRequest(@RequestBody Request request){ requestRepository.delete(request); }
}

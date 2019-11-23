package com.penelakut.soswedding.controller;

import java.util.List;

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

import com.penelakut.soswedding.model.Bid;
import com.penelakut.soswedding.model.Request;
import com.penelakut.soswedding.model.Status;
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

    @GetMapping("/request")
    public List<Request> getAllRequests(){
        return requestRepository.findAll();
    }

    @GetMapping("/request/user/{id}")
    public List<Request> getAllRequestsByUserId(@PathVariable String id){
        return  requestRepository.findAllByUserId(Long.parseLong(id));
    }


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

//  BIDS
    @GetMapping("/request/{id}/bid")
    public List<Bid> getAllBidsByRequestId(@PathVariable String id){
        return  bidRepository.findAllByRequestId(Long.parseLong(id));
    }

    @GetMapping("/bid/{id}")
    public Bid getBidById(@PathVariable String id){
        return bidRepository.findById(Long.parseLong(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("No bid found with id %s ", id)));
    }

    @PostMapping("/request/{id}/bid")
    public Bid createBid(@RequestBody Bid bid){
        return bidRepository.save(bid);
    }

    @PatchMapping("/request/{requestId}/bid/{bidId}/accept")
    public List<Bid> acceptBid(@PathVariable String requestId, @PathVariable String bidId){
        Bid toAccept = getBidById(bidId);
        toAccept.setStatus(Status.ACCEPTED);
        List<Bid> bidList = getAllBidsByRequestId(requestId);
        for (Bid b: bidList){
            if(b.getStatus()!=Status.ACCEPTED){
                b.setStatus(Status.DECLINED);
            }
        }
        return bidRepository.saveAll(bidList);
    }

}

package com.penelakut.soswedding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.penelakut.soswedding.model.Bid;
import com.penelakut.soswedding.model.Status;
import com.penelakut.soswedding.repository.BidRepository;

@RestController
public class BidAPI {

    @Autowired
    private BidRepository bidRepository;

    @GetMapping("/request/{id}/bid")
    public List<Bid> getAllBidsByRequestId(@PathVariable String id){
        return  bidRepository.findAllByRequestId(Long.parseLong(id));
    }

    @GetMapping("/bid/provider/{uuid}")
    public List<Bid> getAllBidsByProviderUuid(@PathVariable String uuid){
        return  bidRepository.findAllByProviderUuid(uuid);
    }

    @GetMapping("/bid/couple/{uuid}")
    public List<Bid> getAllBidsByCoupleUuid(@PathVariable String uuid){
        return  bidRepository.findAllByCoupleUuid(uuid);
    }

    @GetMapping("/bid/{id}")
    public Bid getBidById(@PathVariable String id){
        return bidRepository.findById(Long.parseLong(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("No bid found with id %s ", id)));
    }

    @PostMapping("/bid")
    public Bid createBid(@RequestBody Bid bid){
        return bidRepository.save(bid);
    }

    @PatchMapping("/bid/{bidId}/decline")
    public Bid declineBid(@PathVariable String bidId){
        Bid toDecline = getBidById(bidId);
        toDecline.setStatus(Status.DECLINED);
        return bidRepository.save(toDecline);
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

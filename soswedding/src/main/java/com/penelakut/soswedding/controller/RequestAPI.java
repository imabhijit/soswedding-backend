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

import com.penelakut.soswedding.model.Request;
import com.penelakut.soswedding.repository.RequestRepository;

@RestController
public class RequestAPI {

    @Autowired
    private RequestRepository requestRepository;

    @PostMapping("/request")
    public Request createRequest(@RequestBody Request request){
        return requestRepository.save(request);
    }

    @GetMapping("/request")
    public List<Request> getAllRequests(){
        return requestRepository.findAll();
    }

    @GetMapping("/request/user/{uuid}")
    public List<Request> getAllRequestsByUserUuid(@PathVariable String uuid){
        return  requestRepository.findAllByCoupleUuid(uuid);
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

}

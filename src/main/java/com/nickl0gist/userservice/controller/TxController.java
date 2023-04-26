package com.nickl0gist.userservice.controller;

import com.nickl0gist.userservice.dto.TransactionRequestDTO;
import com.nickl0gist.userservice.dto.TransactionResponseDTO;
import com.nickl0gist.userservice.entity.UserTransaction;
import com.nickl0gist.userservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created on 24.04.2023
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@RestController
@RequestMapping("user/tx")
public class TxController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Mono<TransactionResponseDTO> createTx(@RequestBody Mono<TransactionRequestDTO> requestDTOMono){
        return requestDTOMono.flatMap(transactionService::createTx);
    }

    @GetMapping("{id}")
    public Flux<UserTransaction> getUserById(@PathVariable int id){
        return  transactionService.getAllTxByUserId(id);
    }

}

package com.nickl0gist.userservice.service;

import com.nickl0gist.userservice.dto.TransactionRequestDTO;
import com.nickl0gist.userservice.dto.TransactionResponseDTO;
import com.nickl0gist.userservice.dto.TransactionStatus;
import com.nickl0gist.userservice.entity.UserTransaction;
import com.nickl0gist.userservice.repo.UserRepository;
import com.nickl0gist.userservice.repo.UserTransactionRepository;
import com.nickl0gist.userservice.util.EntityDtoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Created on 24.04.2023
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Service
@Slf4j
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTransactionRepository userTransactionRepository;

    public Mono<TransactionResponseDTO> createTx(TransactionRequestDTO requestDTO) {

        return this.userRepository.updateUserBalance(requestDTO.getUserId(), requestDTO.getAmount())
                .filter(Boolean::booleanValue)
                .map(b -> EntityDtoUtil.toEntity(requestDTO))
                .flatMap(userTransactionRepository::save)
                .map(ut -> EntityDtoUtil.toDto(requestDTO, TransactionStatus.APPROVED))
                .defaultIfEmpty(EntityDtoUtil.toDto(requestDTO, TransactionStatus.DECLINED));
    }

    public Flux<UserTransaction> getAllTxByUserId(int id) {
        return userTransactionRepository.findByUserId(id);
    }
}

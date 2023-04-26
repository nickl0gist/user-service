package com.nickl0gist.userservice.util;

import com.nickl0gist.userservice.dto.TransactionRequestDTO;
import com.nickl0gist.userservice.dto.TransactionResponseDTO;
import com.nickl0gist.userservice.dto.TransactionStatus;
import com.nickl0gist.userservice.dto.UserDTO;
import com.nickl0gist.userservice.entity.User;
import com.nickl0gist.userservice.entity.UserTransaction;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * Created on 20.04.2023
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class EntityDtoUtil {
    public static UserDTO toDto(User user){
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public static User toEntity(UserDTO dto){
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

    public static UserTransaction toEntity(TransactionRequestDTO requestDTO){
        UserTransaction userTransaction = new UserTransaction();
        userTransaction.setUserId(requestDTO.getUserId());
        userTransaction.setAmount(requestDTO.getAmount());
        userTransaction.setTxTimestamp(LocalDateTime.now());
        return userTransaction;
    }

    public static TransactionResponseDTO toDto(TransactionRequestDTO requestDTO, TransactionStatus transactionStatus){
        TransactionResponseDTO responseDTO = new TransactionResponseDTO();
        responseDTO.setAmount(requestDTO.getAmount());
        responseDTO.setUserId(requestDTO.getUserId());
        responseDTO.setStatus(transactionStatus);
        return responseDTO;
    }

    public static TransactionResponseDTO toDto(UserTransaction userTransaction){
        TransactionResponseDTO responseDTO = new TransactionResponseDTO();
        responseDTO.setAmount(userTransaction.getAmount());
        responseDTO.setUserId(userTransaction.getUserId());
        responseDTO.setStatus(userTransaction.g);
        return responseDTO;
    }
}

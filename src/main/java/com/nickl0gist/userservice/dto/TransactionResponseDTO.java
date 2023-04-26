package com.nickl0gist.userservice.dto;

import lombok.Data;
import lombok.ToString;

/**
 * Created on 13.04.2023
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Data
@ToString
public class TransactionResponseDTO {

    private Integer userId;
    private Double amount;
    private TransactionStatus status;

}

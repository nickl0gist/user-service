package com.nickl0gist.userservice.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * Created on 13.04.2023
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Data
@ToString
public class UserTransaction {

    @Id
    private Integer txId;
    private Integer userId;
    private Double amount;
    private LocalDateTime txTimestamp;

}

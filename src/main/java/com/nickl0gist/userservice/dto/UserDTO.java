package com.nickl0gist.userservice.dto;

import lombok.*;

/**
 * Created on 13.04.2023
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private Integer id;
    private String name;
    private Double balance;
}

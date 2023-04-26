package com.nickl0gist.userservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

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
@Table("users")
public class User {

    @Id
    private Integer id;
    private String name;
    private Double balance;
}

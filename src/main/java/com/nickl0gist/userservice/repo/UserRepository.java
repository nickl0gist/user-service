package com.nickl0gist.userservice.repo;

import com.nickl0gist.userservice.entity.User;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Created on 20.04.2023
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
    @Modifying
    @Query("update users " +
            "set balance = balance - :amount " +
            "where id = :userId " +
            "and balance >= :amount")
    Mono<Boolean> updateUserBalance(int userId, double amount);
}

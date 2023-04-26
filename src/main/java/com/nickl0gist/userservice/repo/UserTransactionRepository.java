package com.nickl0gist.userservice.repo;

import com.nickl0gist.userservice.entity.UserTransaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Created on 20.04.2023
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Repository
public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransaction, Integer> {
    Flux<UserTransaction> findByUserId(int userId);
}

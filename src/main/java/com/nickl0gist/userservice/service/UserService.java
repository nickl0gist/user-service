package com.nickl0gist.userservice.service;

import com.nickl0gist.userservice.dto.UserDTO;
import com.nickl0gist.userservice.repo.UserRepository;
import com.nickl0gist.userservice.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created on 20.04.2023
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Flux<UserDTO> all() {
        return this.userRepository.findAll()
                .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDTO> getUserById(int userId) {
        return this.userRepository.findById(userId)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDTO> createUser(Mono<UserDTO> userDTOMono) {
        return userDTOMono
                .map(EntityDtoUtil::toEntity)
                .flatMap(this.userRepository::save)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<UserDTO> updateUser(int id, Mono<UserDTO> userDTOMono) {
        return this.userRepository.findById(id)
                .flatMap(u -> userDTOMono.map(EntityDtoUtil::toEntity)
                        .doOnNext((e -> e.setId(id))))
                .flatMap(this.userRepository::save)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<Void> deleteUser(int id) {
        return this.userRepository.deleteById(id);
    }
}

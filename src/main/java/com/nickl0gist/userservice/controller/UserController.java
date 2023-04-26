package com.nickl0gist.userservice.controller;

import com.nickl0gist.userservice.dto.UserDTO;
import com.nickl0gist.userservice.service.UserService;
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
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("all")
    public Flux<UserDTO> all(){
        return this.userService.all();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<UserDTO>> getUserById(@PathVariable int id){
        return this.userService.getUserById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<UserDTO> createNewUser(@RequestBody Mono<UserDTO> userDTOMono){
        return this.userService.createUser(userDTOMono);
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<UserDTO>> updateUser(@PathVariable int id, @RequestBody Mono<UserDTO> userDTOMono){
        return this.userService.updateUser(id, userDTOMono)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteUSer(@PathVariable int id){
        return userService.deleteUser(id);
    }
}

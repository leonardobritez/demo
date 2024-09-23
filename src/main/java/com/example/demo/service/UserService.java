package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.http.ResponseEntity;


public interface UserService {

    Iterable<User> listAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteUser(Integer id);

    public ResponseEntity registrarUsuario(User user);

}

package com.example.demo.service;
import com.example.demo.repositoriy.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserSeviceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public Iterable<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(Long.valueOf(id)).get();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(Long.valueOf(id));
    }

    public ResponseEntity registrarUsuario(User user) {

       try {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya registrado");
        }

        String token = JwtUtil.generateToken(user.getName());
        user.setToken(token);
        user.setIsActive(Boolean.TRUE);
        user.setLastLogin(LocalDateTime.now());

        User userDto=userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);

       } catch (Exception e) {
          // Manejar cualquier excepción que pueda ocurrir
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }







}

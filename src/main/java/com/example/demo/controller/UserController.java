package com.example.demo.controller;

import com.example.demo.entity.ErrorResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {



        try {
            User user1 = userService.saveUser(user);

            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {

            return new ResponseEntity<>( new ErrorResponse("Error al crear al USUARIO", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);






        } catch (Exception e) {

            return new ResponseEntity<>( new ErrorResponse("Error al crear al USUARIO", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);





}






        //is ok

        //UUID.randomUUID().toString();




      //  return ResponseEntity.ok(user1);
    }

}

package com.example.OrderApp.controllers;

import com.example.OrderApp.models.User;
import com.example.OrderApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User userData) {
        try {
            return new ResponseEntity<>(this.service.createUser(userData), HttpStatus.CREATED);
        } catch(Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        try  {
            return new ResponseEntity<>(this.service.getAllUsers(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(this.service.getUserById(id), HttpStatus.OK);
        } catch(Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyUser(@PathVariable Integer id, @RequestBody User dataUser){
        try {
            return new ResponseEntity<>(this.service.modifyUser(id, dataUser), HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable  Integer id){
        try {
            return new ResponseEntity<>(this.service.deleteUserById(id),HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

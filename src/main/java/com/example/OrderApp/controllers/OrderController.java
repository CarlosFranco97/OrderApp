package com.example.OrderApp.controllers;

import com.example.OrderApp.models.Order;
import com.example.OrderApp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService service;

    @PostMapping
    public ResponseEntity<?> createdOrder(@RequestBody Order dataOrder) {
        try {
            return new ResponseEntity<>(this.service.createdOrder(dataOrder), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(this.service.getOrderById(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders(){
        try {
            return new ResponseEntity<>(this.service.getAllOrders(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyOrderById(@PathVariable Integer id, @RequestBody Order updatedOrder){
        try {
            return new ResponseEntity<>(this.service.modifyOrderById(id, updatedOrder), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(this.service.deteleOrderById(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
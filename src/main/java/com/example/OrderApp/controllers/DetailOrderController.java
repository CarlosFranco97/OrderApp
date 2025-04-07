package com.example.OrderApp.controllers;

import com.example.OrderApp.models.DetailOrder;
import com.example.OrderApp.services.DetailOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/detailorder")
public class DetailOrderController {

    DetailOrderService service;

    @PostMapping
    public ResponseEntity<?> createdDetailOrder(@RequestBody DetailOrder dataDetailOrder){
        try {
            return new ResponseEntity<>(this.service.createdDetailOrder(dataDetailOrder), HttpStatus.CREATED);
        } catch (Exception error){
            return new ResponseEntity<>(error.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailOrderById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.service.getDetailOrderById(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping
    public ResponseEntity<?> getAllDetailsOrders(){
        try {
            return new ResponseEntity<>(this.service.getAllDetailsOrders(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyDetailOrderById(@PathVariable Integer id, @RequestBody DetailOrder updatedDetailOrder){
        try {
            return new ResponseEntity<>(this.service.modifyDetailOrderById(id, updatedDetailOrder), HttpStatus.BAD_REQUEST);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteDetailOrderById(Integer id){
        try {
            return new ResponseEntity<>(this.service.deleteDetailOrderById(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

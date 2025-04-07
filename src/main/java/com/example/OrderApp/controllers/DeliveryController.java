package com.example.OrderApp.controllers;

import com.example.OrderApp.models.Delivery;
import com.example.OrderApp.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService service;

    @PostMapping
    public ResponseEntity<?> createdDelivery(@RequestBody Delivery dataDelivery){
        try{
            return new ResponseEntity<>(this.service.createdDelivery(dataDelivery), HttpStatus.CREATED);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllDeliveries(){
        try {
            return new ResponseEntity<>(this.service.getAllDeliveries(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDeliveryById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(this.service.getDeliveryById(id), HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyDeliveryById(@PathVariable Integer id, @RequestBody Delivery updatedDelivery){
        try {
            return new ResponseEntity<>(this.service.modifyDeliveryById(id, updatedDelivery), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDeliveryById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(this.service.deleteDeliveryById(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

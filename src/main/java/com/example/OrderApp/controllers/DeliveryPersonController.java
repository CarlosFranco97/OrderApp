package com.example.OrderApp.controllers;

import com.example.OrderApp.models.DeliveryPerson;
import com.example.OrderApp.services.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveryperson")
public class DeliveryPersonController {
    @Autowired
    DeliveryPersonService service;

    @PostMapping
    public ResponseEntity<?> createdDeliveryPerson(@RequestBody DeliveryPerson dataDeliveryPerson) {
        try {
            return new ResponseEntity<>(this.service.createdDeliveryPerson(dataDeliveryPerson), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDeliveryPersonById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(this.service.getDeliveryPersonById(id), HttpStatus.OK);
        } catch (Exception error) {

            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping
    public ResponseEntity<?> getAllDeliveriesPersons(){
        try{
            return new ResponseEntity<>(this.service.getAllDeliveriesPersons(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyDeliveryPersonById(@PathVariable Integer id, @RequestBody DeliveryPerson updatedDeliveryPerson){
        try {
            return new ResponseEntity<>(this.service.modifyDeliveryPersonById(id, updatedDeliveryPerson), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDeliveryPersonById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(this.service.deleteDeliveryPersonById(id), HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

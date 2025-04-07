package com.example.OrderApp.controllers;

import com.example.OrderApp.models.Payment;
import com.example.OrderApp.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    PaymentService service;

    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody Payment dataPayment){
        try {
            return new ResponseEntity<>(this.service.createPayment(dataPayment), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPayments(){
        try {
            return new ResponseEntity<>(this.service.getAllPayments(), HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaymentById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(this.service.getPaymentById(id), HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyPaymentById(@PathVariable Integer id, @RequestBody Payment updatedPayment){
        try {
            return new ResponseEntity<>(this.service.modifyPaymentById(id, updatedPayment), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaymentById(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(this.service.deletePaymentById(id), HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

package com.example.OrderApp.controllers;

import com.example.OrderApp.models.Address;
import com.example.OrderApp.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService service;

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody Address dataAddress){
        try {
            return new ResponseEntity<>(this.service.createAddress(dataAddress), HttpStatus.CREATED);
        } catch (Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllAddresses(){
        try {
          return new ResponseEntity<>(this.service.getAllAddresses(), HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(this.service.getAddressById(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyAddress(@PathVariable Integer id, @RequestBody Address updatedAddress){
        try {
            return new ResponseEntity<>(this.service.modifyAddress(id, updatedAddress), HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.service.deleteAddressById(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

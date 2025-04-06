package com.example.OrderApp.controllers;


import com.example.OrderApp.models.Store;
import com.example.OrderApp.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getStoreById(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(this.service.getStoreById(id), HttpStatus.OK);
        } catch(Exception error){
                return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllStores(){
        try{
            return new ResponseEntity<>(this.service.getAllStores(), HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyStoreById(@PathVariable Integer id, @RequestBody Store updatedStore){
        try {
            return new ResponseEntity<>(this.service.modifyStoreById(id, updatedStore), HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping
    public ResponseEntity<?> createdStore(@RequestBody Store dataStore){
        try {
            return new ResponseEntity<>(this.service.createStore(dataStore), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStoreById(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(this.service.deleteStoreById(id), HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

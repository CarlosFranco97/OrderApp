package com.example.OrderApp.services;

import com.example.OrderApp.repository.IDeliveryPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPersonService {
    @Autowired
    IDeliveryPersonRepository repository;
}

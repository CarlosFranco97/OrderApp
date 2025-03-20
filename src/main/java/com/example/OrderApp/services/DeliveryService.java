package com.example.OrderApp.services;

import com.example.OrderApp.repository.IDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    IDeliveryRepository repository;
}

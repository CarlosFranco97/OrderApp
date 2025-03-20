package com.example.OrderApp.services;

import com.example.OrderApp.repository.IDetailOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailOrder {
    @Autowired
    IDetailOrderRepository repository;
}

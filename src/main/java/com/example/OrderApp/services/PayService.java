package com.example.OrderApp.services;

import com.example.OrderApp.repository.IPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PayService {
    @Autowired
    IPayRepository repository;
}

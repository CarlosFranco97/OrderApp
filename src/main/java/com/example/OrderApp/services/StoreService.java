package com.example.OrderApp.services;

import com.example.OrderApp.repository.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    @Autowired
    IStoreRepository repository;
}

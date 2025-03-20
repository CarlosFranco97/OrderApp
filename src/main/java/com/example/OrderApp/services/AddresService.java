package com.example.OrderApp.services;

import com.example.OrderApp.repository.IAddresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddresService {
    @Autowired
    IAddresRepository repository;
}

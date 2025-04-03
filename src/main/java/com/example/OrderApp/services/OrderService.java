package com.example.OrderApp.services;

import com.example.OrderApp.models.Order;
import com.example.OrderApp.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrderRepository repository;
    public List<Order> getAllOrders() throws Exception{
        try {
            return this.repository.findAll();
        } catch (Exception error){
            throw new Exception(error);
        }
    }
}

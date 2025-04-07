package com.example.OrderApp.services;

import com.example.OrderApp.models.Order;
import com.example.OrderApp.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    IOrderRepository repository;

    public Order createdOrder(Order dataOrder) throws Exception {
        try {
            return this.repository.save(dataOrder);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Order getOrderById(Integer id) throws Exception{
        try {
            Optional<Order> searchedOrder = this.repository.findById(id);
            if(searchedOrder.isPresent()){
                return searchedOrder.get();
            } else {
                throw new Exception("Pedido no encontrado en la base de datos");
            }
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Order> getAllOrders() throws Exception{
        try {
            return this.repository.findAll();
        } catch (Exception error){
            throw new Exception(error);
        }
    }

    public Order modifyOrderById(Integer id, Order updatedOrder) throws Exception {
        try {
            Optional<Order> searchedOrder = this.repository.findById(id);
            if(searchedOrder.isPresent()){
                searchedOrder.get().setOrderStatus(updatedOrder.getOrderStatus());
                searchedOrder.get().setTotal(updatedOrder.getTotal());
                return searchedOrder.get();
            } else {
                throw new Exception("Orden no encontrada");
            }
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deteleOrderById(Integer id) throws Exception{
        try {
            Optional<Order> searchedOrder = this.repository.findById(id);
            if(searchedOrder.isPresent()){
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Orden no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}

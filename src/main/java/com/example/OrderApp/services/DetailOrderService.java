package com.example.OrderApp.services;

import com.example.OrderApp.models.DetailOrder;
import com.example.OrderApp.repository.IDetailOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailOrderService {
    @Autowired
    IDetailOrderRepository repository;

    public DetailOrder createdDetailOrder(DetailOrder dataDetailOrder) throws Exception{
        try {
             return this.repository.save(dataDetailOrder);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public DetailOrder getDetailOrderById(Integer id) throws Exception{
        try {
            Optional<DetailOrder> searchedDetailOrder = this.repository.findById(id);
            if(searchedDetailOrder.isPresent()) {
                return searchedDetailOrder.get();
            } else {
                throw new Exception("Detalle de pedido no encontrado en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<DetailOrder> getAllDetailsOrders() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public DetailOrder modifyDetailOrderById(Integer id, DetailOrder updatedDetailOrder) throws  Exception{
        try {
            Optional<DetailOrder> searchedDetailOrder = this.repository.findById(id);
            if(searchedDetailOrder.isPresent()) {
                searchedDetailOrder.get().setQuantityOrder(updatedDetailOrder.getQuantityOrder());
                searchedDetailOrder.get().setSubTotalOrder(updatedDetailOrder.getSubTotalOrder());
                return searchedDetailOrder.get();
            } else {
                throw new Exception("Detalle de pedido no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteDetailOrderById(Integer id) throws Exception{
        try {
            Optional<DetailOrder> searchedDetailOrder = this.repository.findById(id);
            if(searchedDetailOrder.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Detalle de orden no encontrada en la base de datos");
            }

        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}

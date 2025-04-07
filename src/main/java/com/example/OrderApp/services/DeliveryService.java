package com.example.OrderApp.services;

import com.example.OrderApp.models.Delivery;
import com.example.OrderApp.repository.IDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    IDeliveryRepository repository;

    public Delivery createdDelivery(Delivery dataDelivery) throws Exception{
        try {
            return this.repository.save(dataDelivery);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<Delivery> getAllDeliveries() throws Exception {
        try{
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Delivery getDeliveryById(Integer id) throws Exception {
        try {
            Optional<Delivery> searchedDelivery = this.repository.findById(id);
            if(searchedDelivery.isPresent()){
                return searchedDelivery.get();
            } else {
                throw new Exception("Pedido no encontrado en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Delivery modifyDeliveryById(Integer id, Delivery updatedDelivery) throws Exception{
        try {
            Optional<Delivery> searchedDelivery = this.repository.findById(id);
            if(searchedDelivery.isPresent()){
                searchedDelivery.get().setDeliveryStatus(updatedDelivery.getDeliveryStatus());
                searchedDelivery.get().setDateDelivery(updatedDelivery.getDateDelivery());
                return searchedDelivery.get();
            } else {
                throw new Exception("No se ha encontrado la entrega");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteDeliveryById(Integer id) throws Exception{
        try {
            Optional<Delivery> searchedDelivery = this.repository.findById(id);
            if(searchedDelivery.isPresent()){
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("No se ha encontrado la entrega");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}

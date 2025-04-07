package com.example.OrderApp.services;

import com.example.OrderApp.models.DeliveryPerson;
import com.example.OrderApp.repository.IDeliveryPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryPersonService {
    @Autowired
    IDeliveryPersonRepository repository;

    public DeliveryPerson createdDeliveryPerson(DeliveryPerson dataDeliveryPerson) throws Exception{
        try {
             return this.repository.save(dataDeliveryPerson);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public DeliveryPerson getDeliveryPersonById(Integer id) throws Exception{
        try {
            Optional<DeliveryPerson> searchedDeliveryPerson = this.repository.findById(id);
            if(searchedDeliveryPerson.isPresent()){
                return searchedDeliveryPerson.get();
            } else {
                throw new Exception("Repartidor no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<DeliveryPerson> getAllDeliveriesPersons() throws Exception{
        try {
            return this.repository.findAll();
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    public DeliveryPerson modifyDeliveryPersonById(Integer id, DeliveryPerson updatedDeliveryPerson) throws Exception {
        try {
            Optional<DeliveryPerson> searchedDeliveryPerson = this.repository.findById(id);
            if(searchedDeliveryPerson.isPresent()){
                searchedDeliveryPerson.get().setDeliveryPersonName(updatedDeliveryPerson.getDeliveryPersonName());
                searchedDeliveryPerson.get().setDeliveryPersonPhone(updatedDeliveryPerson.getDeliveryPersonPhone());
                searchedDeliveryPerson.get().setDeliveryPersonEmail(updatedDeliveryPerson.getDeliveryPersonEmail());
                return searchedDeliveryPerson.get();
            } else {
                throw new Exception("Repartidor no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    public boolean deleteDeliveryPersonById(Integer id) throws Exception{
        try {
            Optional<DeliveryPerson> searchedDeliveryPerson = this.repository.findById(id);
            if(searchedDeliveryPerson.isPresent()){
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Repartidor no encontrado");
            }
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}

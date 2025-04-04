package com.example.OrderApp.services;

import com.example.OrderApp.models.Address;
import com.example.OrderApp.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    IAddressRepository repository;


    public Address createAddress(Address dataAddress) throws Exception{
        try {
            return this.repository.save(dataAddress);
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Address> getAllAddresses() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Address getAddressById(Integer id) throws Exception{
        try {
            Optional<Address> searchedAddress =  this.repository.findById(id);
            if(searchedAddress.isPresent()){
                return searchedAddress.get();
            } else {
                throw new Exception("No se ha encontrado la direccion en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Address modifyAddress(Integer id, Address updatedAddress) throws Exception{
        try {
            Optional<Address> searchedAddress = this.repository.findById(id);
            if(searchedAddress.isPresent()){
               searchedAddress.get().setCountry(updatedAddress.getCountry());
               searchedAddress.get().setCity(updatedAddress.getCity());
               searchedAddress.get().setStreet(updatedAddress.getStreet());
               return searchedAddress.get();
            } else {
                throw new Exception("No se ha encontrado la direccion en la base de datos");
            }
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteAddressById(Integer id) throws Exception{
        try {
            Optional<Address> searchedAddress = this.repository.findById(id);
            if(searchedAddress.isPresent()){
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("No se ha encontrado la dirección");
            }
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}

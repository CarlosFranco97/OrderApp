package com.example.OrderApp.services;

import com.example.OrderApp.models.Store;
import com.example.OrderApp.repository.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    IStoreRepository repository;

    public Store getStoreById(Integer id) throws Exception {
        try {
            Optional<Store> searchedStore = this.repository.findById(id);
            if(searchedStore.isPresent()){
                return searchedStore.get();
            } else {
                throw new Exception("Tienda no encontrada");
            }
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Store> getAllStores() throws Exception{
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //modificar por id
    public Store modifyStoreById(Integer id, Store updatedStore) throws Exception{
        try{
            Optional<Store> searchedStore = this.repository.findById(id);
            if(searchedStore.isPresent()){
                searchedStore.get().setStorePhone(updatedStore.getStorePhone());
                return this.repository.save(searchedStore.get());
            } else {
                throw new Exception("Tienda no econtrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //guardar
    public Store createStore(Store store) throws Exception{
        try {
          return this.repository.save(store);
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //eliminar por id
    public boolean deleteStoreById(Integer id) throws Exception{
        try {
            Optional<Store> searchedStore = this.repository.findById(id);
            if(searchedStore.isPresent()){
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Tienda no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}

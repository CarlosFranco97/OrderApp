package com.example.OrderApp.services;

import com.example.OrderApp.models.Product;
import com.example.OrderApp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    IProductRepository repository;

    //crear, buscar por id, eliminar por id, modificar, obtener todos
    public Product createProduct(Product product) throws Exception{
        try {
            return this.repository.save(product);
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Product getProductById(Integer id) throws Exception{
        try {
            Optional<Product> searchedProduct = this.repository.findById(id);
            if(searchedProduct.isPresent()) {
                return searchedProduct.get();
            } else {
                throw new Exception("Usuario no econtrado en la base de datos");
            }
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Product> getAllProducts() throws Exception{
        try {
            return this.repository.findAll();
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Product modifyProductById(Integer id, Product updatedProduct) throws Exception{
        try{
            Optional<Product> searchedProduct = this.repository.findById(id);
            if(searchedProduct.isPresent()){
                searchedProduct.get().setProductPrice(updatedProduct.getProductPrice());
                searchedProduct.get().setDescription(updatedProduct.getDescription());
                return this.repository.save(searchedProduct.get());
            } else {
                throw new Exception("Producto no encontrado");
            }
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteProductById(Integer id) throws Exception{
        try {
            Optional<Product> searchedProduct = this.repository.findById(id);
            if(searchedProduct.isPresent()){
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Producto no encontrado en la base de datos");
            }
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}

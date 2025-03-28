package com.example.OrderApp.services;

import com.example.OrderApp.models.Payment;
import com.example.OrderApp.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    IPaymentRepository repository;

    public Payment createPayment(Payment payment) throws Exception{
        try {
            return this.repository.save(payment);
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Payment> getAllPayments() throws Exception{
        try {
            return this.repository.findAll();
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Payment getPaymentById(Integer id) throws Exception {
        try {
            Optional<Payment> searchedPayment = this.repository.findById(id);
            if(searchedPayment.isPresent()){
                return searchedPayment.get();
            } else {
                throw new Exception("Pago no encontrado en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Payment modifyPaymentById(Integer id, Payment updatedPayment) throws Exception {
        try {
            Optional<Payment> searchedPayment = this.repository.findById(id);
            if(searchedPayment.isPresent()){
                searchedPayment.get().setStatusPayment(updatedPayment.getStatusPayment());
                return this.repository.save(searchedPayment.get());
            } else {
                throw new Exception("El pago no se encuentra en la base de datos");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean deletePaymentById(Integer id) throws Exception{
        try {
            Optional<Payment> searchedPayment = this.repository.findById(id);
            if(searchedPayment.isPresent()){
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("El pago no se encuentra en la base de datos");
            }
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}

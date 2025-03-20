package com.example.OrderApp.repository;

import com.example.OrderApp.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery, Integer> {

}

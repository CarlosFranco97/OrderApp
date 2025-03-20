package com.example.OrderApp.repository;

import com.example.OrderApp.models.DeliveryPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeliveryPersonRepository extends JpaRepository<DeliveryPerson, Integer> {
}

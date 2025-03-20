package com.example.OrderApp.repository;

import com.example.OrderApp.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddresRepository extends JpaRepository<Address, Integer> {
}

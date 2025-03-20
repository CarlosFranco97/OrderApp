package com.example.OrderApp.repository;

import com.example.OrderApp.models.DetailOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetailOrderRepository extends JpaRepository<DetailOrder, Integer> {
}

package com.example.OrderApp.repository;

import com.example.OrderApp.models.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPayRepository extends JpaRepository<Pay, Integer> {
}

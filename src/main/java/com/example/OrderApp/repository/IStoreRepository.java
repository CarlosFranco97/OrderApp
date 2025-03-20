package com.example.OrderApp.repository;

import com.example.OrderApp.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoreRepository extends JpaRepository<Store, Integer> {
}

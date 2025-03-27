package com.example.OrderApp.repository;

import com.example.OrderApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    //dentro del repo van las consultas personalizadas
}

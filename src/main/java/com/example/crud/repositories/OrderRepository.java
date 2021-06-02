package com.example.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

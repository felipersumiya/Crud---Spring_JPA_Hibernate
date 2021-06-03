package com.example.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}

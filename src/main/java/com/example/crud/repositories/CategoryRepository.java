package com.example.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

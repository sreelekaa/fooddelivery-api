// FoodRepo.java
package com.example.demo;

// import com.example.demo.Food;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Food, Integer> {

}
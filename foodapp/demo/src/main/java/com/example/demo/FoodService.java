package com.example.demo;



import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepo foodRepo;

    public Food createFood(@NonNull Food food) {
        return foodRepo.save(food);
    }

    public List<Food> getAllFoods() {
        return foodRepo.findAll();
    }

    public Food getFoodById(@NonNull Integer id) {
        return foodRepo.findById(id).orElse(null);
    }

    public boolean updateFood(int id, Food food) {
        if (getFoodById(id) == null) {
            return false;
        }

        try {
            foodRepo.save(food);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean deleteFood(int id) {
        if (getFoodById(id) == null) {
            return false;
        }

        foodRepo.deleteById(id);
        return true;
    }
}
package com.example.demo;
// FoodController.java


// import com.example.demo.Food;
// import com.example.demo.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/food")
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food newFood = foodService.createFood(food);
        if (newFood != null) {
            return new ResponseEntity<>(newFood, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/foods")
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = foodService.getAllFoods();
        if (!foods.isEmpty()) {
            return new ResponseEntity<>(foods, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/food/{foodId}")
    public ResponseEntity<Food> updateFood(@PathVariable int foodId, @RequestBody Food food) {
        boolean updated = foodService.updateFood(foodId, food);
        if (updated) {
            return new ResponseEntity<>(food, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/food/{foodId}")
    public ResponseEntity<Boolean> deleteFood(@PathVariable int foodId) {
        boolean deleted = foodService.deleteFood(foodId);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
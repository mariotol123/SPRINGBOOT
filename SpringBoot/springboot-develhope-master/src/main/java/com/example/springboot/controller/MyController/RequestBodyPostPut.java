package com.example.springboot.controller.MyController;

import com.example.springboot.controller.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RequestBodyPostPut {
    List<Meal> marioMeals = Arrays.asList(
            new Meal("Mario","Pizza napoletana con bufala","7.99"),
            new Meal("Marco","Patate al forno","2.99"),
            new Meal("Michele","Crocche con patate","3.99")
    );
    @PostMapping(value = "add/meal")
    public ResponseEntity<String> addMeal(@RequestBody Meal newMeal) {
        marioMeals.add(newMeal);
        return ResponseEntity.ok("New meal added successfully!");
    }

    @PutMapping("/meal/{name}")
    public ResponseEntity<String> updateMeal(@PathVariable String name, @RequestBody Meal updatedMeal) {
        for (Meal meal : marioMeals) {
            if (meal.getName().equals(name)) {
                meal.setDescription(updatedMeal.getDescription());
                meal.setPrice(updatedMeal.getPrice());
                return ResponseEntity.ok("Meal updated successfully!");
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "delete/meal{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable String name){
        marioMeals.removeIf(meal -> meal.getName().equals(name));
        return ResponseEntity.ok("Im deleting");
    }


    @DeleteMapping(value = "/meal/price/{price}")
    public ResponseEntity<String> deleteMealsAbovePrice(@PathVariable double price) {
        int initialSize = marioMeals.size();
        marioMeals = marioMeals.stream()
                .filter(meal -> Double.parseDouble(meal.getPrice()) <= price)
                .collect(Collectors.toList());

        if (marioMeals.size() < initialSize) {
            return ResponseEntity.ok("Meals above the specified price deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping(value = "/meal/{name}/price")
    public ResponseEntity<String> updateMealPrice(@PathVariable String name, @RequestBody String updatedPrice) {
        for (Meal meal : marioMeals) {
            if (meal.getName().equals(name)) {
                meal.setPrice(updatedPrice);
                return ResponseEntity.ok("Meal price updated successfully!");
            }
        }
        return ResponseEntity.notFound().build();
    }
}

package com.example.springboot.controller.MyController;

import com.example.springboot.controller.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
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
}

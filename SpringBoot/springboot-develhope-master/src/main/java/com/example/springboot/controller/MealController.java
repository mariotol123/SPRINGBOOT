package com.example.springboot.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MealController {
    List<Meal> chefsSpecial = Arrays.asList(
    new Meal("Mario","Mangia il riso il lunedi","2.00"),
    new Meal("Marco","Mangia il pane","1.00"),
    new Meal("Michele", "Mangia il pollo","2.99"),
    new Meal("Matteo", "Mangia la cvarne", "7.99")
    );
    @GetMapping(value = "/get/chefs-special")
    public ResponseEntity<Meal> index() {return ResponseEntity.ok(
            chefsSpecial.get((int) (Math.random() * chefsSpecial.size()))
    );
    }

    @GetMapping(value = "/get/chefs-special2/{dayOfTheWeekendIndex}")
    public ResponseEntity<?> getChefsSpecial(@PathVariable("dayOfTheWeekendIndex") int dayOfTheWeekendIndex){
        if (dayOfTheWeekendIndex < 0 ||dayOfTheWeekendIndex > 4){
            return ResponseEntity.badRequest().body("Invalid");
        }
        return ResponseEntity.ok(chefsSpecial.get(dayOfTheWeekendIndex));
    }

}

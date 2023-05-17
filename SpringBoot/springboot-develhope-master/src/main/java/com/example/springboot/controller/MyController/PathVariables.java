package com.example.springboot.controller.MyController;

import com.example.springboot.controller.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PathVariables {
    List<Meal> marioMeals = Arrays.asList(
            new Meal("Mario","Pizza napoletana con bufala","7.99"),
            new Meal("Marco","Patate al forno","2.99"),
            new Meal("Michele","Crocche con patate","3.99")
    );

    @GetMapping(value = "/get/mario-meals")
    public ResponseEntity<List<Meal>> gregExercise(){
        return ResponseEntity.ok(marioMeals);
    }

    @GetMapping(value = "/get/mario-meals/{name}")
    public ResponseEntity<Meal> getMealByName(@PathVariable("name") String name){
        for (Meal meal : marioMeals) {
            if (meal.getName().equalsIgnoreCase(name)) {
                return ResponseEntity.ok(meal);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/meal/description-match/{phrase}")
    public ResponseEntity<Meal> getMealByDescription(@PathVariable("phrase") String description){
        for (Meal meal : marioMeals) {
            if (meal.getDescription().equalsIgnoreCase(description)) {
                return ResponseEntity.ok(meal);
            }
        }
        return ResponseEntity.notFound().build();
    }

}

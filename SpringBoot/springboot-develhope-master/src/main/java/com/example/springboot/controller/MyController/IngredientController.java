package com.example.springboot.controller.MyController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createdIngredient = ingredientService.createIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIngredient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Long id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        return ResponseEntity.ok(ingredients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable("id") Long id, @RequestBody Ingredient updatedIngredient) {
        Ingredient ingredient = ingredientService.updateIngredient(id, updatedIngredient);
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable("id") Long id) {
        ingredientService.deleteIngredient(id);
        return ResponseEntity.noContent().build();
    }
}


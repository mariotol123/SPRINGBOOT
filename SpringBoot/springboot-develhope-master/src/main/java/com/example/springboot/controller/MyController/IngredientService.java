package com.example.springboot.controller.MyController;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ingredient non trovato con ID: " + id));
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient updateIngredient(Long id, Ingredient updatedIngredient) {
        Ingredient ingredient = getIngredientById(id);
        ingredient.setName(updatedIngredient.getName());
        ingredient.setDescription(updatedIngredient.getDescription());
        return ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}

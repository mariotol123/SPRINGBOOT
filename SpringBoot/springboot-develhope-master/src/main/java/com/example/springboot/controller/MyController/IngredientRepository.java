package com.example.springboot.controller.MyController;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {}

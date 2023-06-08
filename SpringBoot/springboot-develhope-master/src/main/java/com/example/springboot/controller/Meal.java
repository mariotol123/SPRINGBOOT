package com.example.springboot.controller;

import com.example.springboot.controller.MyController.Ingredient;
import jakarta.persistence.*;

import java.util.List;

public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    protected String name;
    protected String description;
    protected String price;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<com.example.springboot.controller.MyController.Ingredient> ingredients;
    public Meal(){

    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Meal(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

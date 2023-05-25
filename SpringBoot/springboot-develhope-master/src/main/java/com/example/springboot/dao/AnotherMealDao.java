package com.example.springboot.dao;

import com.example.springboot.model.Meal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class AnotherMealDao {
    private List<com.example.springboot.model.Meal> chefsSpecial = new ArrayList<>();

    public void addMeal(Meal meal){
        this.chefsSpecial.add(meal);
    }

    public void deleteMeal (String mealName){
        this.chefsSpecial.removeIf(meal -> meal.getName().equals(mealName));
    }

    public void updateMeal(com.example.springboot.model.Meal meal){
        this.chefsSpecial.removeIf(meal1 -> meal1.getName().equals(meal.getName()));
        this.chefsSpecial.add(meal);
    }

    public List<com.example.springboot.model.Meal> getMeals(){
        return this.chefsSpecial;
    }
}

package com.example.springboot.service;

import com.example.springboot.dao.AnotherMealDao;
import com.example.springboot.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private  AnotherMealDao anotherMealDao;
    @Autowired
    public MealService(AnotherMealDao anotherMealDao) {

        this.anotherMealDao = anotherMealDao;
    }

    public void addMeal(com.example.springboot.model.Meal meal) {
        if (meal == null) throw new IllegalArgumentException("meal cannot add");
        if (meal.getName() == null || meal.getName().isEmpty()) throw new IllegalArgumentException("Meal name cannot be null or empty");
        if (meal.getDescription() == null || meal.getDescription().isEmpty()) throw new IllegalArgumentException("Meal description dont exist");
        if (meal.getPrice() <= 0) throw new IllegalArgumentException("Meal price cannot be less than or equal to 0!");
        if (meal.getPrice() > 100) throw new IllegalArgumentException("Meal price cannot be greater than 100!");
        anotherMealDao.addMeal(meal);
    }

    public void deleteMeal (String mealName){
        anotherMealDao.deleteMeal(mealName);
    }

    public void updateMeal(Meal meal){
        anotherMealDao.updateMeal(meal);
    }

    public List<com.example.springboot.model.Meal> getMeals(){
        return anotherMealDao.getMeals();
    }
}

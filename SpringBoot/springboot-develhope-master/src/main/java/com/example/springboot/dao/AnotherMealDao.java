package com.example.springboot.dao;

import com.example.springboot.model.Meal;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class AnotherMealDao {

    private MealDao mealDao;
    private double MIN_SUMMER_TEMP=20.0;

    @Autowired
    public AnotherMealDao(MealDao mealDao) {
        this.mealDao = mealDao;
    }

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

    public List<Meal> getWinterMeals(){
        getCurrentTemperatureInCentigrade();

        if (getCurrentTemperatureInCentigrade() < MIN_SUMMER_TEMP) return new ArrayList<>();
        return mealDao.findByIsWinterMeal(true);
    }

    public List<Meal> getSummerMeals(){
       getCurrentTemperatureInCentigrade();

       if (getCurrentTemperatureInCentigrade() > MIN_SUMMER_TEMP) return new ArrayList<>();
       return mealDao.findByIsSummerMeal(true);
    }

    private Double getCurrentTemperatureInCentigrade(){
        try {
            JSONObject response =
                    Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=40.88&longitude=14.24&current_weather=true")
                            .asJson().getBody().getObject();
            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}

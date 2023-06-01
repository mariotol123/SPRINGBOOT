package com.example.springboot.controller;


import com.example.springboot.dao.AnotherMealDao;
import com.example.springboot.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MealController {
    @Autowired
    public MealController(AnotherMealDao anotherMealDao) {
        this.anotherMealDao = anotherMealDao;
    }


    private AnotherMealDao anotherMealDao;

   /// @GetMapping(value = "/get/chefs-special")
   // public ResponseEntity<Meal> index() {return ResponseEntity.ok(
            //anotherMealDao.get((int) (Math.random() * mealService.size()))
    //);
    //}

    //@GetMapping(value = "/get/chefs-special2/{dayOfTheWeekendIndex}")
    //public ResponseEntity<?> getChefsSpecial(@PathVariable("dayOfTheWeekendIndex") int dayOfTheWeekendIndex){
        //if (dayOfTheWeekendIndex < 0 ||dayOfTheWeekendIndex > 4){
          //  return ResponseEntity.badRequest().body("Invalid");
       // }
        //return ResponseEntity.ok(chefsSpecial.get(dayOfTheWeekendIndex));
    //}

    @PutMapping(value = "put/meal")
    public ResponseEntity<String> putMeals(@RequestBody com.example.springboot.model.Meal meal){
        try {
            anotherMealDao.addMeal(meal);
            return ResponseEntity.ok("Meal added");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping (value = "delete/meal{mealName}")
    public ResponseEntity<String> deleteMeals(@PathVariable String mealName){
        anotherMealDao.deleteMeal(mealName);
        return ResponseEntity.ok("Meal removed");
    }

    @PostMapping(value = "post/meal")
    public ResponseEntity<String> postMeals(@RequestBody Meal meal){
        anotherMealDao.updateMeal(meal);
        return ResponseEntity.ok("Meal updated");
    }

}

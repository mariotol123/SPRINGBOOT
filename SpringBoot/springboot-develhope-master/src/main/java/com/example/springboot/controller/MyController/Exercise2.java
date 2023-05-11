package com.example.springboot.controller.MyController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercise2 {
    @GetMapping(value = "/greeting")
    public ResponseEntity<String> SecondoEsercizio(){

        return ResponseEntity.status(200).body("good afternoon");
    }
}

package com.example.springboot.controller.MyController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Exercise4 {

    @GetMapping("/random")
    public ResponseEntity<String> QuartoEsercizio() {
        boolean randomValue = new Random().nextBoolean();

        if (randomValue) {
            return ResponseEntity.ok("200 OK");
        } else {
            return ResponseEntity.badRequest().body("400 Bad Request");
        }
    }
}

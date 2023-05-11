package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercise1 {
    @GetMapping(value = "/hello")
    public ResponseEntity<String> primoEsercizio(){

        return ResponseEntity.ok("Hello World!");
    }

}
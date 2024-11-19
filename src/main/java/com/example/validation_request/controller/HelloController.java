package com.example.validation_request.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation_request.dto.request.InputRequestDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hello")
public class HelloController {
    

    @PostMapping
    public String helloWorld(@Valid @RequestBody InputRequestDTO inputRequestDTO) {
        return "Hello World";
    }

}

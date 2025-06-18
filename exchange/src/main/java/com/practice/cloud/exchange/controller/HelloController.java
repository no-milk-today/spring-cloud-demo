package com.practice.cloud.exchange.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        // Возвращаем простой JSON: {"message": "Hello from B"}
        return Collections.singletonMap("message", "Hello from B");
    }
}

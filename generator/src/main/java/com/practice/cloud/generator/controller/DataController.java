package com.practice.cloud.generator.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DataController {

    private final RestTemplate restTemplate;

    public DataController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @GetMapping("/get-data")
    public String getData() {
        // Отправляем запрос через Gateway (порт 8080) к сервису B
        String url = "http://localhost:8080/api/hello";
        String responseBody = restTemplate.getForObject(url, String.class);
        return "Ответ от сервиса B: " + responseBody;
    }
}

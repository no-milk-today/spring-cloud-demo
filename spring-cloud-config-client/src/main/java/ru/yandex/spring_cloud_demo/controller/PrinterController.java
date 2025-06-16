package ru.yandex.spring_cloud_demo.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/texts")
@RefreshScope // Дополнительный скоуп бина, благодаря которому конфигурации внутри могут быть обновлены
public class PrinterController {

    // Проперти из конфиг-сервера, которая может быть автоматически обновлена
    @Value("${text-to-print}")
    private String textToPrint;

    // Бин Bus-пропертей приложения. Используем чтобы доставать busId
    // и ориентироваться какой из инстансов ответил на запрос
    private final BusProperties busProps;

    public PrinterController(BusProperties busProps) {
        this.busProps = busProps;
    }

    @GetMapping
    public String getText() {
        var message = busProps.getId() + ":\n" + textToPrint;
        System.out.println(message);
        return message;
    }

    @PostConstruct
    public void init() {
        System.out.println("Приложению присвоен busId : " + busProps.getId());
    }
}

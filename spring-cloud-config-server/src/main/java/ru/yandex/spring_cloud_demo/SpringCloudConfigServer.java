package ru.yandex.spring_cloud_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer // аннотация для включения режима Config-сервер
public class SpringCloudConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServer.class, args);
    }
}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class FirstTaskApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FirstTaskApplication.class, args);
        System.out.println("задание 1");
    }
}

package com.nexem.serve;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.nio.file.Paths;
import java.util.Arrays;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        System.out.println(Paths.get("..\\application.properties").toAbsolutePath());
//        System.setProperty("app.home", "");
//        SpringApplication.run(Main.class, args);
    }
}
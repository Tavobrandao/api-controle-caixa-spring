package com.borracharia.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaController {

    @GetMapping("/boas-vindas")
    public String darBoasVindas() {
        return "Bem-vindo à API da Borracharia Chega Rápido! O servidor Spring Boot está rodando.";
    }
}
package com.example.condominio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

    @GetMapping("/ola")
    public String ola() {
        return "ola";
    }
}


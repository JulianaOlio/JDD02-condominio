package com.example.condominio;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendaTelefonica")
public class AgendaTelefonicaController {

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String ola() {
        return "agendaTelefonica";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@Valid @RequestBody ContratoEntrada contratoEntrada) {
        return ResponseEntity.ok(contratoEntrada.getNome());
    }

    @PutMapping("/atualizar/{identificador}")
    public String atualizar(@Valid @RequestBody ContratoEntrada contratoEntrada,
                            @PathVariable("identificador") String id) {
        return id;
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam("nome") String nome) {
        return nome;
    }
}

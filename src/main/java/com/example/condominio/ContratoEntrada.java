package com.example.condominio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ContratoEntrada {
    @NotNull(message = "Por favor, preencha o campo nome")
    private String nome;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 11)
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public ContratoEntrada() {
    }

    public ContratoEntrada(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

}

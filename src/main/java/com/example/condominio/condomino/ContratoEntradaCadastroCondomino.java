package com.example.condominio.condomino;

import jakarta.validation.constraints.NotNull;

public class ContratoEntradaCadastroCondomino {
    @NotNull
    private String nome;
    private Integer dddCelular;
    private Long celular;
    @NotNull
    private String email;
    @NotNull
    private String bloco;
    @NotNull
    private String apartamento;
    @NotNull
    private String cpf;

    public ContratoEntradaCadastroCondomino() {
    }

    public ContratoEntradaCadastroCondomino(String nome, Integer dddCelular, Long celular, String email, String bloco, String apartamento, String cpf) {
        this.nome = nome;
        this.dddCelular = dddCelular;
        this.celular = celular;
        this.email = email;
        this.bloco = bloco;
        this.apartamento = apartamento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(Integer ddCelular) {
        this.dddCelular = ddCelular;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

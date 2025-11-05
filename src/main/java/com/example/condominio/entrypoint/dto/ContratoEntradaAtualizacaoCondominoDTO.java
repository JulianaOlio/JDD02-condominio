package com.example.condominio.entrypoint.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratoEntradaAtualizacaoCondominoDTO {

    @NotNull
    @NotEmpty
    @NotBlank
    private String nomeCompleto;

    private String email;
    private String telefone;

    @NotNull
    @NotBlank
    @NotEmpty
    private String bloco;

    @NotNull
    @NotBlank
    @NotEmpty
    private String apartamento;

}
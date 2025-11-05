package com.example.condominio.entrypoint.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContratoEntradaCadastroCondominoDTO {

    @NotNull
    @NotEmpty
    @NotBlank
    private String nomeCompleto;

    @NotEmpty
    @NotNull
    @NotBlank
    @Size(min = 11, max = 11, message = "Digite os 11 caracteres do CPF, sem traço ou ponto")
    private String cpf;

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
package com.example.condominio.entrypoint.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CondominoSaidaDTO {
    private String id;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String telefone;
    private String bloco;
    private String apartamento;

}

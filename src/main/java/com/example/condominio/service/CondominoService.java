package com.example.condominio.service;

import com.example.condominio.domain.Condomino;

public interface CondominoService {

    boolean existeCPF(String cpf);

    Condomino cadastrar(Condomino novoCondomino);
}

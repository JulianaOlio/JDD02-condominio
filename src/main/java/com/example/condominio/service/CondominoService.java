package com.example.condominio.service;

import com.example.condominio.domain.Condomino;

import java.util.List;
import java.util.Optional;

public interface CondominoService {

    boolean existeCPF(String cpf);

    Condomino cadastrar(Condomino novoCondomino);

    boolean existeCondomino(String id);

    void deletar(String id);

    List<Condomino> consultarTodos();

    Optional<Condomino> buscarPorId(String id);

    Condomino atualizar(Condomino existente);

    List<Condomino> consultarCondominoComFiltros(String nome, String cpf, String bloco, String apartamento);
}

package com.example.condominio.business;

import com.example.condominio.domain.Condomino;

import java.util.List;

public interface CondominoBusiness {

    Condomino cadastrarCondomino(Condomino novoCondomino);

    List<Condomino> consultarTodosCondominos();

    void deletarCondomino(String id);

    Condomino atualizarCondomino(Condomino condominoConvertido);

    List<Condomino> consultarCondominoComFiltros(String nome, String cpf, String bloco, String apartamento);
}

package com.example.condominio.business.impl;

import com.example.condominio.business.CondominoBusiness;
import com.example.condominio.core.exceptions.RecursoNaoEncontradoException;
import com.example.condominio.core.exceptions.RegraDeNegocioException;
import com.example.condominio.domain.Condomino;
import com.example.condominio.service.CondominoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CondominoBusinessImpl implements CondominoBusiness {

    private CondominoService condominoService;

    @Override
    public Condomino cadastrarCondomino(Condomino novoCondomino) {

        if(condominoService.existeCPF(novoCondomino.getCpf())){
            throw new RegraDeNegocioException("CPF já cadastrado");
        }
        Condomino condominoSalvo = condominoService.cadastrar(novoCondomino);

        return condominoSalvo;
    }

    @Override
    public List<Condomino> consultarTodosCondominos() {
        return condominoService.consultarTodos();
    }

    @Override
    public void deletarCondomino(String id) {
        if(!condominoService.existeCondomino(id)){
            throw new RecursoNaoEncontradoException("Condomino não encontrado.");
        }
        condominoService.deletar(id);
    }

    @Override
    public Condomino atualizarCondomino(Condomino condomino) {
        Condomino existente = condominoService.buscarPorId(condomino.getId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Condomino não encontrado"));

        Condomino atualizado = condominoService.atualizar(existente);

        return atualizado;
    }

    @Override
    public List<Condomino> consultarCondominoComFiltros(String nome, String cpf, String bloco, String apartamento) {
        return condominoService.consultarCondominoComFiltros(nome, cpf, bloco, apartamento);
    }
}

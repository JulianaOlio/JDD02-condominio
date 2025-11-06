package com.example.condominio.service.impl;

import com.example.condominio.core.exceptions.RegraDeNegocioException;
import com.example.condominio.domain.Condomino;
import com.example.condominio.service.CondominoService;
import com.example.condominio.service.adapter.CondominoAdapterService;
import com.example.condominio.service.repository.CondominoRepository;
import com.example.condominio.service.repository.entity.CondominoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondominoServiceImpl implements CondominoService {
    @Autowired
    private CondominoRepository condominoRepository;
    @Autowired
    private CondominoAdapterService condominoAdapterService;

    @Override
    public boolean existeCPF(String cpf) {
        return condominoRepository.findByCpf(cpf).isPresent();
    }

    @Override
    public Condomino cadastrar(Condomino novoCondomino) {
        CondominoEntity condominoConvertido = condominoAdapterService.toEntity(novoCondomino);
        CondominoEntity condominoCadastrado = condominoRepository.save(condominoConvertido);
        return condominoAdapterService.toDomain(condominoCadastrado);
    }

    @Override
    public boolean existeCondomino(String id) {
        return condominoRepository.findById(id).isPresent();
    }

    @Override
    public void deletar(String id) {
        condominoRepository.deleteById(id);

    }

    @Override
    public List<Condomino> consultarTodos() {
        List<CondominoEntity> condominos = condominoRepository.findAll();
        return condominos.stream().map(condominoAdapterService::toDomain).toList();
    }

    @Override
    public Optional<Condomino> buscarPorId(String id) {
        return condominoRepository.findById(id)
                .map(condominoAdapterService::toDomain);
    }

    @Override
    public Condomino atualizar(Condomino existente) {
        CondominoEntity entity = condominoRepository.findById(existente.getId()).get();

        existente.setNomeCompleto(entity.getNomeCompleto());
        existente.setEmail(entity.getEmail());
        existente.setTelefone(entity.getTelefone());
        existente.setBloco(entity.getBloco());
        existente.setApartamento(entity.getApartamento());

        CondominoEntity salvo = condominoRepository.save(entity);
        return condominoAdapterService.toDomain(salvo);
    }

    @Override
    public List<Condomino> consultarCondominoComFiltros(String nome, String cpf, String bloco, String apartamento) {
        if ((nome == null || nome.isEmpty()) &&
                (cpf == null || cpf.isEmpty()) &&
                (bloco == null || bloco.isEmpty()) &&
                (apartamento == null || apartamento.isEmpty())) {
            throw new RegraDeNegocioException("Informe ao menos um dos filtros (nome, cpf, bloco, apartamento)");
        }
        return condominoRepository
                .findByNomeCompletoContainingIgnoreCaseAndCpfContainingIgnoreCaseAndBlocoContainingIgnoreCaseAndApartamentoContainingIgnoreCase(
                        nome, cpf, bloco, apartamento)
                .stream()
                .map(condominoAdapterService::toDomain)
                .toList();
    }
}

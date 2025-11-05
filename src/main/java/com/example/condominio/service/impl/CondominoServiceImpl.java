package com.example.condominio.service.impl;

import com.example.condominio.domain.Condomino;
import com.example.condominio.service.CondominoService;
import com.example.condominio.service.adapter.CondominoAdapterService;
import com.example.condominio.service.repository.CondominoRepository;
import com.example.condominio.service.repository.entity.CondominoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

package com.example.condominio.business.impl;

import com.example.condominio.business.CondominoBusiness;
import com.example.condominio.domain.Condomino;
import com.example.condominio.core.exceptions.RegraDeNegocioException;
import com.example.condominio.service.CondominoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
}

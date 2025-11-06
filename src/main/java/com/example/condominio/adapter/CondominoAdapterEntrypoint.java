package com.example.condominio.adapter;

import com.example.condominio.domain.Condomino;
import com.example.condominio.entrypoint.dto.CondominoSaidaDTO;
import com.example.condominio.entrypoint.dto.ContratoEntradaAtualizacaoCondominoDTO;
import com.example.condominio.entrypoint.dto.ContratoEntradaCadastroCondominoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = java.util.UUID.class)
public interface CondominoAdapterEntrypoint {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    Condomino toDomain(ContratoEntradaCadastroCondominoDTO contratoEntrada);

    CondominoSaidaDTO toSaidaDTO(Condomino condomino);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    Condomino toDomain(ContratoEntradaAtualizacaoCondominoDTO contratoEntradaAtualizacaoCondominoDTO);

     @Mapping(target = "cpf", ignore = true)
    Condomino toDomain(ContratoEntradaAtualizacaoCondominoDTO contratoEntradaAtualizacaoCondominoDTO, String id);
}

package com.example.condominio.service.adapter;

import com.example.condominio.service.repository.entity.CondominoEntity;
import com.example.condominio.domain.Condomino;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CondominoAdapterService {

    CondominoEntity toEntity(Condomino condomino);

    Condomino toDomain(CondominoEntity condominoCadastrado);
}

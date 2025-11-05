package com.example.condominio.service.repository;

import com.example.condominio.service.repository.entity.CondominoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CondominoRepository extends JpaRepository<CondominoEntity, String> {

    Optional<CondominoEntity> findByCpf(String cpf);

    List<CondominoEntity> findByNomeCompletoContainingIgnoreCaseAndCpfContainingIgnoreCaseAndBlocoContainingIgnoreCaseAndApartamentoContainingIgnoreCase(String nome, String cpf, String bloco, String apartamento);

}
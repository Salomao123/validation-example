package com.example.validation_request.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.validation_request.domain.entities.LogDiarioAtendimento;

@Repository
public interface LogDiarioAtendimentoRepository extends JpaRepository<LogDiarioAtendimento, String> {

    @Procedure("PSELLOGDIARIO00")
    List<Object[]> consultarLogDiario(
    @Param("p_codigoCentral") String p_codigoCentral,
    @Param("p_tipoAtendimento") String p_tipoAtendimento,
    @Param("p_agencia") String p_agencia,
    @Param("p_conta") String p_conta,
    @Param("p_nsu") String p_nsu,
    @Param("p_cpfCnpj") String p_cpfCnpj,
    @Param("p_nCartao") String p_nCartao,
    @Param("p_chavePesquisa") String p_chavePesquisa,
    @Param("p_identificacaoPesquisa") String p_identificacaoPesquisa);
    
}

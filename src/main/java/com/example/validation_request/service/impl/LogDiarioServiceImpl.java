package com.example.validation_request.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.validation_request.dto.request.LogDiarioRequestDto;
import com.example.validation_request.dto.response.ChavePesquisaRecord;
import com.example.validation_request.dto.response.LogDiarioResponseProcRecord;
import com.example.validation_request.repositories.LogDiarioAtendimentoRepository;
import com.example.validation_request.service.LogDiarioService;


@Service
public class LogDiarioServiceImpl implements LogDiarioService {

    private final LogDiarioAtendimentoRepository repository;

    @Autowired
    public LogDiarioServiceImpl(LogDiarioAtendimentoRepository repository) {
        this.repository = repository;
    }

   @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @Override
    public List<LogDiarioResponseProcRecord> consultarLogDiario(LogDiarioRequestDto input) {

        List<Object[]> response = repository.consultarLogDiario(
            input.codigoCentral(),
            input.tipoAtendimento(),
            input.agencia(),
            input.conta(),
            input.nsu(),
            input.cpfCnpj(),
            input.numeroCartao(),
            input.chavePesquisa(),
            input.identificacaoAtendente()
        );

        return Optional.ofNullable(response)
        .filter(Objects::nonNull)
        .map(this::toListLogDiarioResponseProcDtos)
        .orElseThrow(() -> new RuntimeException("Error"));
    }


     private List<LogDiarioResponseProcRecord> toListLogDiarioResponseProcDtos(List<Object[]> objects) {
        return objects.stream()
        .map(this::toLogDiarioResponseProcDtos)
        .collect(Collectors.toList());
    }

    private LogDiarioResponseProcRecord toLogDiarioResponseProcDtos(Object[] objects) {

        return new LogDiarioResponseProcRecord(
            null != objects[0] ? objects[0].toString().trim() : null,
            null != objects[1] ? (int) objects[1] : 0,
            null != objects[2] ? (int) objects[2] : 0,
            null != objects[3] ? objects[3].toString().trim() : null,
            null != objects[4] ? objects[4].toString().trim() : null,
            null != objects[5] ? objects[5].toString().trim() : null,
            null != objects[6] ? objects[6].toString().trim() : null,
            null != objects[7] ? objects[7].toString().trim() : null,
            null != objects[8] ? objects[8].toString().trim() : null,
            null != objects[9] ? (int) objects[9] : 0,
            null != objects[10] ? (int) objects[10] : 0,
            null != objects[11] ? objects[11].toString().trim() : null,
            buildChavePesquisa(objects)
                );
            }

    private List<ChavePesquisaRecord> buildChavePesquisa(Object[] objects) {
        if (objects[12] != null) {
            String[] split = objects[12].toString().split(",");
            
              return Arrays.stream(split)
                    .map(chave -> new ChavePesquisaRecord(chave.trim())).toList();
            
        }
        
        return null;
    }
}

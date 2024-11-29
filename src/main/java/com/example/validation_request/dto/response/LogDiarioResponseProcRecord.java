package com.example.validation_request.dto.response;

import java.util.List;

public record LogDiarioResponseProcRecord(
    String cNsu,
    int nAg,
    int nCta,
    String nCpf,
    String codigoCentral,
    String tipoAtendimento,
    String horarioAtendimento,
    String identificacaoAtendente,
    String mnemonico,
    int timeoutRequisicao,
    int tipoBloco,
    String rDados,
    List<ChavePesquisaRecord> chavePesquisa
) {
    
}

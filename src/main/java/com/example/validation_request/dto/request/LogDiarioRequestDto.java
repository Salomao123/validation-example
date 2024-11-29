package com.example.validation_request.dto.request;

public record LogDiarioRequestDto(
    String mnemonico,
    String codigoCentral,
    String tipoAtendimento,
    String agencia,
    String conta,
    String telefoneCliente,
    String nsu,
    String cpfCnpj,
    String numeroCartao,
    String chavePesquisa,
    String identificacaoAtendente,
    String tipoBloco,
    String dataHoraInicio,
    String dataHoraFim,
    String numeroPagina,
    String timestampRequisicao,
    String timeoutRequisicao,
    String versaoServico
) {
    
}
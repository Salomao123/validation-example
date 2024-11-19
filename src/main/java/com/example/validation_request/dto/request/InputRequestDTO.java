package com.example.validation_request.dto.request;

import com.example.validation_request.validation.ValidInputRequest;
import lombok.Builder;
import lombok.Data;

@ValidInputRequest
@Data
@Builder
public class InputRequestDTO {
    private String nome;
    private String sobrenome;
    private String email;
}

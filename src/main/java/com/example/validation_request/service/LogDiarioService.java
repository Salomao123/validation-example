package com.example.validation_request.service;

import java.util.List;

import com.example.validation_request.dto.request.LogDiarioRequestDto;
import com.example.validation_request.dto.response.LogDiarioResponseProcRecord;

public interface LogDiarioService {
    List<LogDiarioResponseProcRecord> consultarLogDiario(LogDiarioRequestDto input);
}

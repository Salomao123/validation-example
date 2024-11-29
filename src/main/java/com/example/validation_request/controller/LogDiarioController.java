package com.example.validation_request.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation_request.dto.request.LogDiarioRequestDto;
import com.example.validation_request.dto.response.LogDiarioResponseProcRecord;
import com.example.validation_request.service.LogDiarioService;

@RestController
@RequestMapping("/v1/log-diario")
public class LogDiarioController {
    private final LogDiarioService logDiarioService;

    @Autowired
    public LogDiarioController(com.example.validation_request.service.LogDiarioService logDiarioService) {
        this.logDiarioService = logDiarioService;
    }

    @PostMapping("consultar")
    public ResponseEntity<List<LogDiarioResponseProcRecord>> helloWorld(@RequestBody LogDiarioRequestDto input) {
        return ResponseEntity.ok().body(logDiarioService.consultarLogDiario(input));
    }

}

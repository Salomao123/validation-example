package com.example.validation_request.domain.entities;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TCTRLLOGATDMT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogDiarioAtendimento {
    @Id
    @Column(name = "CNSU")
    private String nsu;

    @Column(name = "DTIMESTAMPRQUIS")
    private ZonedDateTime dtTimestampRequisicao;

    @Column(name = "NVRSAOSERVC")
    private int versao;

    @Column(name = "CIDATDEN")
    private String identificacaoAtendimento;

    @Column(name = "NFONE")
    private String nFone;

    @Column(name = "NAG")
    private int agencia;

    @Column(name = "NCTA")
    private int conta;

    @Column(name = "CMNEMO")
    private String mnemonico;

    @Column(name = "NCPF")
    private String cCpfCnpj;

    @Column(name = "CTOBLOCO")
    private int tipoBloco;

    @Column(name = "NCATAO")
    private String numeroCartao;

    @Column(name = "RDADOS")
    private String dados;

    @Column(name = "CCTNRLATDMTPOTALGSTAOGRAL")
    private String codigoCentral;

    @Column(name = "CTOPOTALGSTAOGRAL")
    private String tipoAtendimento;

    @Column(name = "CDETLHTPOGSTAOGRAL")
    private String detalheTipoAtendimento;


}

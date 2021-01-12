package com.geo.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class EstadoDTO {

    private Integer id;
    private String nome;
    private Long qtdPopulacao;
    private BigDecimal custoPopulacional;
    private byte[] bandeiraImg;

    private Set<CidadeDTO> cidadeDTOSet = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQtdPopulacao() {
        return qtdPopulacao;
    }

    public byte[] getBandeiraImg() {
        return bandeiraImg;
    }

    public void setBandeiraImg(byte[] bandeiraImg) {
        this.bandeiraImg = bandeiraImg;
    }

    public void setQtdPopulacao(Long qtdPopulacao) {
        this.qtdPopulacao = qtdPopulacao;
    }

    public Set<CidadeDTO> getCidadeDTOSet() {
        return cidadeDTOSet;
    }

    public BigDecimal getCustoPopulacional() {
        return custoPopulacional;
    }

    public void setCustoPopulacional(BigDecimal custoPopulacional) {
        this.custoPopulacional = custoPopulacional;
    }
}

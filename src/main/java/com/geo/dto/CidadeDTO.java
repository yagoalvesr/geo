package com.geo.dto;

public class CidadeDTO {

    private Integer id;
    private String nome;
    private Long qtdPopulacao;

    private EstadoDTO estadoDTO = new EstadoDTO();

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

    public void setQtdPopulacao(Long qtdPopulacao) {
        this.qtdPopulacao = qtdPopulacao;
    }

    public EstadoDTO getEstadoDTO() {
        return estadoDTO;
    }

    public void setEstadoDTO(EstadoDTO estado) {
        this.estadoDTO = estado;
    }
}

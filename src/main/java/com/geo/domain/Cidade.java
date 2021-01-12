package com.geo.domain;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "qtd_populacao")
    private Long qtdPopulacao;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado = new Estado();

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

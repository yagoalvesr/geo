package com.geo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "qtd_populacao")
    private Long qtdPopulacao;
    @Column(name = "bandeira_img")
    private byte[] bandeiraImg;

    @OneToMany(mappedBy = "estado")
    private Set<Cidade> cidadeSet = new HashSet<>();

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

    public Set<Cidade> getCidadeSet() {
        return cidadeSet;
    }
}

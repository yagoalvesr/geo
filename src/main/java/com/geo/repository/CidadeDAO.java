package com.geo.repository;

import com.geo.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeDAO extends JpaRepository<Cidade, Integer> {

    @Query("select c from Cidade c where c.nome = :nome and c.estado.id = :estadoId")
    Optional<Cidade> selectByNomeAndAndEstadoId(@Param("nome") String nome, @Param("estadoId") Integer estadoId);

    @Query("select sum(c.qtdPopulacao) from Cidade c where c.estado.id = :estadoId")
    Long selectSumQtdPopulacaoPorEstadoId(@Param("estadoId") Integer estadoId);
}

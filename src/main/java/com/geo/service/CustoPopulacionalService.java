package com.geo.service;

import org.springframework.stereotype.Service;

@Service
public class CustoPopulacionalService {

    private static final Double CUSTO_DOLAR_POR_CIDADAO = 123.45;
    private static final Double DESCONTO = 12.3;

    public Double recuperaCustoPopulacional(Long qtdPopulacao) {
        Double custoPopulacional = 0.0;

        if (qtdPopulacao > 50000) {
            custoPopulacional = 50000 * CUSTO_DOLAR_POR_CIDADAO;
            Long qtdPopulacaoacima50000 = qtdPopulacao - 50000;
            custoPopulacional = custoPopulacional + (qtdPopulacaoacima50000 * (CUSTO_DOLAR_POR_CIDADAO * (100 - DESCONTO) / 100));

        } else {
            custoPopulacional = qtdPopulacao * CUSTO_DOLAR_POR_CIDADAO;
        }

        return custoPopulacional;
    }


}

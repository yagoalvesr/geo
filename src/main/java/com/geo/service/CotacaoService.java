package com.geo.service;

import com.geo.Util.DataUtil;
import com.geo.domain.Cidade;
import com.geo.domain.Cotacao;
import com.geo.domain.Estado;
import com.geo.dto.CidadeDTO;
import com.geo.exception.GeoException;
import com.geo.mapper.CidadeMapper;
import com.geo.repository.CidadeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CotacaoService {

    public static final String URL_BASE = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/";

    public Double recuperarCotacao() {

        String diaAtual = DataUtil.recuperarDiaAtual();

        RestTemplate restTemplate = new RestTemplate();
        StringBuilder sb = new StringBuilder();

        sb.append(URL_BASE);
        sb.append("CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='");
        sb.append(diaAtual);
        sb.append("'&$format=json");

        String url = sb.toString();
        ResponseEntity<Cotacao> response = restTemplate.getForEntity(url, Cotacao.class);
        return response.getBody().getValue().get(0).getCotacaoCompra();
    }
}

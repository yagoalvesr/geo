package com.geo.service;

import com.geo.domain.Estado;
import com.geo.dto.EstadoDTO;
import com.geo.exception.GeoException;
import com.geo.mapper.EstadoMapper;
import com.geo.repository.EstadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadoService {

    @Autowired
    private EstadoDAO estadoDAO;

    @Autowired
    private EstadoMapper estadoMapper;

    @Autowired
    private CustoPopulacionalService custoPopulacionalService;

    @Autowired
    private CotacaoService cotacaoService;

    public List<EstadoDTO> recuperarEstados() {
        List<Estado> estadoList = estadoDAO.findAll();
        List<EstadoDTO> estadoDTOList = new ArrayList<>();

        if (!estadoList.isEmpty()) {

            estadoDTOList = estadoList
                    .stream()
                    .map(estado -> {
                        EstadoDTO estadoDTO = estadoMapper.toDTO(estado);
                        recuperarCustoPopulacional(estadoDTO);
                        return estadoDTO;
                    })
                    .collect(Collectors.toList());
        }

        return estadoDTOList;
    }

    public EstadoDTO recuperarEstadoPorId(Integer id) throws GeoException {
        Optional<Estado> estado = estadoDAO.findById(id);
        EstadoDTO estadoDTO;

        if (estado.isPresent()) {
            estadoDTO = estadoMapper.toDTO(estado.get());
            recuperarCustoPopulacional(estadoDTO);
        } else {
            throw new GeoException("Não foi possível encontrar esse estado");
        }

        return estadoDTO;
    }

    public void atualizarQtdPopulacaoEstado(Estado estado) {
        Optional<Estado> estadoOptional = estadoDAO.findById(estado.getId());
        if (estadoOptional.isPresent()) {
            Estado estadoEcontrado = estadoOptional.get();
            estadoEcontrado.setQtdPopulacao(estado.getQtdPopulacao());
            estadoDAO.save(estadoEcontrado);
        }
    }

    private void recuperarCustoPopulacional(EstadoDTO estadoDTO) {
        Double custoPopulacinonal = custoPopulacionalService.recuperaCustoPopulacional(estadoDTO.getQtdPopulacao());
        Double cotacaoAtual = cotacaoService.recuperarCotacao();
        Double custoPopulacionalCovertido = custoPopulacinonal * cotacaoAtual;
        estadoDTO.setCustoPopulacional(new BigDecimal(custoPopulacionalCovertido));
    }
}

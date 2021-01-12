package com.geo.service;

import com.geo.domain.Cidade;
import com.geo.domain.Estado;
import com.geo.dto.CidadeDTO;
import com.geo.exception.GeoException;
import com.geo.mapper.CidadeMapper;
import com.geo.repository.CidadeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    @Autowired
    private CidadeDAO cidadeDAO;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private CidadeMapper cidadeMapper;

    public List<CidadeDTO> recuperarCidades() {
        List<Cidade> cidadeList = cidadeDAO.findAll();
        List<CidadeDTO> cidadeDTOList = new ArrayList<>();

        if (!cidadeList.isEmpty()) {

            cidadeDTOList = cidadeList
                    .stream()
                    .map(cidade -> cidadeMapper.toDTO(cidade))
                    .collect(Collectors.toList());
        }

        return cidadeDTOList;
    }

    public CidadeDTO recuperarCidadePorId(Integer id) throws GeoException {
        Optional<Cidade> cidade = cidadeDAO.findById(id);
        CidadeDTO cidadeDTO;

        if (cidade.isPresent()) {
            cidadeDTO = cidadeMapper.toDTO(cidade.get());
        } else {
            throw new GeoException("Não foi possível encontrar essa cidade");
        }

        return cidadeDTO;
    }

    public void inserirCidade(CidadeDTO cidadeDTO) throws GeoException {

        Cidade cidade = cidadeMapper.toEntity(cidadeDTO);
        Optional<Cidade> cidadeOptional = cidadeDAO.selectByNomeAndAndEstadoId(cidadeDTO.getNome(), cidadeDTO.getEstadoDTO().getId());

        if (!cidadeOptional.isPresent()) {
            cidadeDAO.save(cidade);
            Long qtdPopulacaoEstado = cidadeDAO.selectSumQtdPopulacaoPorEstadoId(cidade.getEstado().getId());
            Estado estado = cidade.getEstado();
            estado.setQtdPopulacao(qtdPopulacaoEstado);
            estadoService.atualizarQtdPopulacaoEstado(estado);
        } else {
            throw new GeoException("Não é possivel salvar duas cidades com o mesmo nome para o mesmo estado!");
        }
    }

    public void inserirCidadeList(List<CidadeDTO> cidadeDTOList) {
        cidadeDTOList.forEach(cidadeDTO -> {
            try {
                inserirCidade(cidadeDTO);
            } catch (GeoException e) {
                e.printStackTrace();
            }
        });
    }

    public void deletarCidade(Integer id) throws GeoException {
        CidadeDTO cidadeDTO = recuperarCidadePorId(id);
        if (!cidadeDTO.getEstadoDTO().getId().equals(1)) {
            cidadeDAO.deleteById(id);
        } else {
            throw new GeoException("Não é possível deletar cidades do Rio Grande do Sul");
        }
    }
}

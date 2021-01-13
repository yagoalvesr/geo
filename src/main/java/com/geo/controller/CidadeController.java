package com.geo.controller;

import com.geo.domain.Cidade;
import com.geo.dto.CidadeDTO;
import com.geo.dto.RetornoDTO;
import com.geo.exception.GeoException;
import com.geo.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CidadeDTO>> recuperarCidades() {
        List<CidadeDTO> cidadeDTOList = cidadeService.recuperarCidades();
        return ResponseEntity.ok().body(cidadeDTOList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity recuperarCidadePorId(@PathVariable Integer id) throws GeoException {
        try {
            CidadeDTO cidadeDTO = cidadeService.recuperarCidadePorId(id);
            return ResponseEntity.ok().body(cidadeDTO);
        } catch (GeoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity inserirCidade(@RequestBody CidadeDTO cidadeDTO) throws GeoException {
        try {
            cidadeService.inserirCidade(cidadeDTO);
            RetornoDTO retornoDTO = new RetornoDTO("Cidade inserida com sucesso!", true);
            return ResponseEntity.ok().body(retornoDTO);
        } catch (GeoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/inserir-cidades", method = RequestMethod.POST)
    public ResponseEntity<RetornoDTO> inserirCidadeList(@RequestBody List<CidadeDTO> cidadeDTOList) {
        cidadeService.inserirCidadeList(cidadeDTOList);
        RetornoDTO retornoDTO = new RetornoDTO("Cidades inseridas com sucesso!", true);
        return ResponseEntity.ok().body(retornoDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletarCidadePorId(@PathVariable Integer id) throws GeoException {
        try {
            cidadeService.deletarCidade(id);
            RetornoDTO retornoDTO = new RetornoDTO("Cidade deletada com sucesso!", true);
            return ResponseEntity.ok().body(retornoDTO);
        } catch (GeoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

package com.geo.controller;

import com.geo.domain.Cidade;
import com.geo.dto.CidadeDTO;
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
    public ResponseEntity<String> inserirCidade(@RequestBody CidadeDTO cidadeDTO) throws GeoException {
        try {
            cidadeService.inserirCidade(cidadeDTO);
            return ResponseEntity.ok().body("Cidade inserida com sucesso!");
        } catch (GeoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/inserir-cidades", method = RequestMethod.POST)
    public ResponseEntity<String> inserirCidadeList(@RequestBody List<CidadeDTO> cidadeDTOList) {
        cidadeService.inserirCidadeList(cidadeDTOList);
        return ResponseEntity.ok().body("Cidades inseridas com sucesso!");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletarCidadePorId(@PathVariable Integer id) throws GeoException {
        try {
            cidadeService.deletarCidade(id);
            return ResponseEntity.ok().body("Cidade deletada com sucesso!");
        } catch (GeoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

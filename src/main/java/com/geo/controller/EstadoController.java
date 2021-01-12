package com.geo.controller;

import com.geo.dto.EstadoDTO;
import com.geo.exception.GeoException;
import com.geo.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EstadoDTO>> recuperarEstados() {
        List<EstadoDTO> estadoDTOList = estadoService.recuperarEstados();

        return ResponseEntity.ok().body(estadoDTOList);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity recuperarEstadoPorId(@PathVariable Integer id) throws GeoException {
        try {
            EstadoDTO estadoDTO = estadoService.recuperarEstadoPorId(id);
            return ResponseEntity.ok().body(estadoDTO);
        } catch (GeoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

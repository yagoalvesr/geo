package com.geo.mapper;

import com.geo.domain.Estado;
import com.geo.dto.EstadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EstadoMapper {

    @Mapping(target = "cidadeDTOSet", source = "cidadeSet")
    EstadoDTO toDTO(Estado estado);
}

package com.geo.mapper;

import com.geo.domain.Cidade;
import com.geo.dto.CidadeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CidadeMapper {

    @Mapping(target = "estadoDTO", source = "estado")
    CidadeDTO toDTO(Cidade cidade);

    @Mapping(target = "estado", source = "estadoDTO")
    Cidade toEntity(CidadeDTO cidadeDTO);
}

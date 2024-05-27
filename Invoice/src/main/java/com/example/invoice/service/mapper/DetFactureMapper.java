package com.example.invoice.service.mapper;


import com.example.invoice.dto.DetFactureDTO;
import com.example.invoice.model.DetFacture;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface DetFactureMapper {

    @Mapping(target = "enteteFactDTO", ignore = true)
    DetFactureDTO entityToDto(DetFacture detFacture);

    @InheritInverseConfiguration

    @Mapping(target = "facture", ignore = true)
    DetFacture dtoToEntity(DetFactureDTO detFactureDTO);

}

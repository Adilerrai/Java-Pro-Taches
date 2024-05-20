package com.example.invoice.service.mapper;

import com.example.invoice.model.Client;
import com.example.invoice.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface ClientMapper {
     @Mapping(target = "enteteFacts", ignore = true)
     ClientDTO entityToDto(Client client);
     Client dtoToEntity(ClientDTO clientDTO);

}

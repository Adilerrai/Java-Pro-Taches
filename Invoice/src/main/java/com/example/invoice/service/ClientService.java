package com.example.invoice.service;

import com.example.invoice.dto.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ClientService {
    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long id);
    ClientDTO saveClient(ClientDTO clientDTO);
    void deleteClient(Long id);
    ClientDTO updateClient(ClientDTO clientDTO);



}

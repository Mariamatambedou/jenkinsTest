package com.example.demo.service;

import com.example.demo.DTO.ClientDTO;
import com.example.demo.DTO.ProduitDTO;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {

    ClientDTO createClient(ClientDTO clientDTO);
    //ClientDTO updateClient(ClientDTO clientDTO);
  //  ClientDTO deleteClient(ClientDTO clientDTO);
    List<ClientDTO> getAllClients() throws ChangeSetPersister.NotFoundException;
}

package com.example.demo.service;

import com.example.demo.DTO.ClientDTO;
import com.example.demo.DTO.ProduitDTO;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.mapper.ProduitMapper;
import com.example.demo.modele.Client;
import com.example.demo.modele.Produit;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }
    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        // Ajoutez d'autres logiques de validation ou de traitement ici
        client = clientRepository.save(client);
        return clientMapper.toDto(client);
    }
   @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }
}

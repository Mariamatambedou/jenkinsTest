package com.example.demo.mapper;

import com.example.demo.DTO.ClientDTO;
import com.example.demo.DTO.ProduitDTO;
import com.example.demo.modele.Client;
import com.example.demo.modele.Produit;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public class ClientMapper {
    public Client toEntity(ClientDTO clientDTO){
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setPrenom(clientDTO.getPrenom());
        client.setNom(clientDTO.getNom());
        client.setEmail(clientDTO.getEmail());
        return client;
    }


    public ClientDTO toDto(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setPrenom(client.getPrenom());
        clientDTO.setNom(client.getNom());
        clientDTO.setEmail(client.getEmail());
        return clientDTO;
    }
}

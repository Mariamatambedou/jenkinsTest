package com.example.demo.Controller;

import com.example.demo.DTO.ClientDTO;
import com.example.demo.DTO.ProduitDTO;
import com.example.demo.service.ClientService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/cliente/creer")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        ClientDTO nouveauClient = clientService.createClient(clientDTO);
        return new ResponseEntity<>(nouveauClient, HttpStatus.CREATED);
    }
    @GetMapping("/listeClient")
    public ResponseEntity<List<ClientDTO>> getAllClients() throws ChangeSetPersister.NotFoundException {
        List<ClientDTO> clients = (List<ClientDTO>) clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}

package com.example.demo.service;

import com.example.demo.DTO.ProduitDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;


public interface ProduitService {
    ProduitDTO createProduit(ProduitDTO produitDTO);
    ProduitDTO getProduitById(Long id) throws ChangeSetPersister.NotFoundException;
    List<ProduitDTO> getAllProduits() throws ChangeSetPersister.NotFoundException;
    // Ajoutez d'autres méthodes de service ici
}

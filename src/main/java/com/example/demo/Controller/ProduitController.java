package com.example.demo.Controller;

import com.example.demo.DTO.ProduitDTO;
import com.example.demo.modele.Produit;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.service.ProduitService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ProduitController {
    private final ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping("/produit")
    public ResponseEntity<ProduitDTO> createProduit(@RequestBody ProduitDTO produitDTO) {
        ProduitDTO nouveauProduit = produitService.createProduit(produitDTO);
        return new ResponseEntity<>(nouveauProduit, HttpStatus.CREATED);
    }

    @GetMapping("/lire/{id}")
    public ResponseEntity<ProduitDTO> getProduitById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        ProduitDTO produitDTO = produitService.getProduitById(id);
        return new ResponseEntity<>(produitDTO, HttpStatus.OK);
    }
    @GetMapping("/listeProduit")
    public ResponseEntity<List<ProduitDTO>> getAllProduits() throws ChangeSetPersister.NotFoundException {
        List<ProduitDTO> produits = (List<ProduitDTO>) produitService.getAllProduits();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }
    }


package com.example.demo.service;

import com.example.demo.DTO.ProduitDTO;
import com.example.demo.mapper.ProduitMapper;
import com.example.demo.modele.Produit;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;

    @Autowired
    public ProduitServiceImpl(ProduitRepository produitRepository, ProduitMapper produitMapper) {
        this.produitRepository = produitRepository;
        this.produitMapper = produitMapper;
    }

    @Override
    public ProduitDTO createProduit(ProduitDTO produitDTO) {
        Produit produit = produitMapper.toEntity(produitDTO);
        // Ajoutez d'autres logiques de validation ou de traitement ici
        produit = produitRepository.save(produit);
        return produitMapper.toDto(produit);
    }

    @Override
    public ProduitDTO getProduitById(Long id) throws ChangeSetPersister.NotFoundException {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException()); // Exemple d'exception

        return produitMapper.toDto(produit);
    }
    @Override
    public List<ProduitDTO> getAllProduits() {
        List<Produit> produits = produitRepository.findAll();
        return produits.stream()
                .map(produitMapper::toDto)
                .collect(Collectors.toList());
    }


}

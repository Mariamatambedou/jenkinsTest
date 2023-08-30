package com.example.demo.mapper;

import com.example.demo.DTO.ProduitDTO;
import com.example.demo.modele.Produit;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public class ProduitMapper {
    public Produit toEntity(ProduitDTO  produitDTO){
        Produit produit = new Produit();
        produit.setId(produitDTO.getId());
        produit.setNom(produitDTO.getNom());
        produit.setPrix(produitDTO.getPrix());
        produit.setPrixAchat(produitDTO.getPrixAchat());
        return produit;
    }


    public ProduitDTO toDto(Produit produit) {
        ProduitDTO produitDTO = new ProduitDTO();
        produitDTO.setId(produit.getId());
        produitDTO.setNom(produit.getNom());
        produitDTO.setPrix(produit.getPrix());
        produitDTO.setPrixAchat(produit.getPrixAchat());
        return produitDTO;
    }
}



package com.example.demo.DTO;

import lombok.Data;

@Data
public class ProduitDTO {
    private Long id;
    private String nom;
    private int prix;
    private int prixAchat;

    @Override
    public String toString() {
        return "ProduitDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", prixAchat=" + prixAchat +
                '}';
    }
}

package com.example.constructionxpert.Models;

public class Ressource {

    String nomRessource;
    String typeRessource;
    int quantite;

    public Ressource(String nomRessource, String typeRessource, int quantite) {
        this.nomRessource = nomRessource;
        this.typeRessource = typeRessource;
        this.quantite = quantite;
    }

    public Ressource() {
    }

    public String getNomRessource() {
        return nomRessource;
    }

    public void setNomRessource(String nomRessource) {
        this.nomRessource = nomRessource;
    }

    public String getTypeRessource() {
        return typeRessource;
    }

    public void setTypeRessource(String typeRessource) {
        this.typeRessource = typeRessource;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}

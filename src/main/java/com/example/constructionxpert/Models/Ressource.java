package com.example.constructionxpert.Models;

public class Ressource {
    private int idRessource;
    private String nomRessource;
    private String typeRessource;
    private int quantite;

    public Ressource(int idRessource,String nomRessource, String typeRessource, int quantite) {
        this.idRessource = idRessource;
        this.nomRessource = nomRessource;
        this.typeRessource = typeRessource;
        this.quantite = quantite;
    }

    public Ressource() {
    }

    public int getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
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

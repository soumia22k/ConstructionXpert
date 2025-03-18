package com.example.constructionxpert.Models;

import java.util.Date;

public class Tache {

    String nomTache;
    String description;
    Date dateDebut;
    Date dateFin;
    String ressource;

    public Tache(String nomTache, String description, Date dateDebut, Date dateFin, String ressource) {
        this.nomTache = nomTache;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.ressource = ressource;
    }

    public Tache() {
    }

    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getRessource() {
        return ressource;
    }

    public void setRessource(String ressource) {
        this.ressource = ressource;
    }
}

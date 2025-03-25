package com.example.constructionxpert.Models;
import java.util.Date;

public class Tache {
    private int idTache;
    private String nomTache;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private int idRessource;
    private int idProjet; //  refléter la relation avec projet

    public Tache(int idTache, String nomTache, String description, Date dateDebut, Date dateFin, int idRessource, int idProjet) {
        this.idTache = idTache;
        this.nomTache = nomTache;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idRessource = idRessource;
        this.idProjet = idProjet;
    }

    public Tache() {
    }

    public int getIdTache() {
        return idTache;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
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

    public int getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }
}
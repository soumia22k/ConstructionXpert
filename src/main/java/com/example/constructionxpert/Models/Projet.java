package com.example.constructionxpert.Models;

import java.util.Date;

public class Projet {
    private int idProjet;
    private String nomProjet;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private int budget;

    public Projet(int idProjet, String nomProjet, String description, Date dateDebut, Date dateFin, int budget) {
        this.idProjet = idProjet;
        this.nomProjet = nomProjet;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.budget = budget;
    }

    public Projet(String nomProjet, String description, Date dateDebut, Date dateFin, int budget) {
        this.nomProjet = nomProjet;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.budget = budget;
    }

    public Projet() {

    }


    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}

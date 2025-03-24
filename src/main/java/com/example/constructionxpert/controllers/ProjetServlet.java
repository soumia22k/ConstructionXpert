package com.example.constructionxpert.controllers;

import com.example.constructionxpert.DAO.ProjetDAO;
import com.example.constructionxpert.Models.Projet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/projets")
public class ProjetServlet extends HttpServlet {
    private ProjetDAO projetDAO;

    @Override
    public void init() {
        projetDAO = new ProjetDAO();
    }

    // Méthodes privées pour chaque opération CRUD
    private void createProjet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Projet projet=new Projet();
               projetDAO.createProjet(projet);
        req.getRequestDispatcher("projet.jsp").forward(req, resp);
    }

    private void readProjets(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Projet> projets = projetDAO.getAllProjects();
        req.setAttribute("projets", projets);
        req.getRequestDispatcher("listeProjet.jsp").forward(req, resp);
    }

    private void updateProjet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProjet = Integer.parseInt(req.getParameter("id"));
        Projet projet = projetDAO.getProjetById(idProjet);
        req.setAttribute("projet", projet);
        req.getRequestDispatcher("modifierProjet.jsp").forward(req, resp);
    }

    private void deleteProjet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProjet = Integer.parseInt(req.getParameter("id"));
        boolean isDeleted = projetDAO.deleteProjet(idProjet);
        if (isDeleted) {
            resp.sendRedirect("projets");
        } else {
            req.setAttribute("error", "Erreur lors de la suppression.");
            readProjets(req, resp); // Réafficher la liste en cas d'erreur
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Switch pour appeler les fonctions
        switch (action != null ? action : "") {
            case "create":
                createProjet(request, response);
                break;
            case "read":
                readProjets(request, response);
                break;
            case "update":
                updateProjet(request, response);
                break;
            case "delete":
                deleteProjet(request, response);
                break;
            default:
                readProjets(request, response); // Par défaut, afficher la liste
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String nom = request.getParameter("nom");
            String description = request.getParameter("description");
            Date dateDebut = Date.valueOf(request.getParameter("dateDebut"));
            Date dateFin = Date.valueOf(request.getParameter("dateFin"));
            int budget = Integer.parseInt(request.getParameter("budget"));

            Projet projet = new Projet(0, nom, description, dateDebut, dateFin, budget);
            projetDAO.createProjet(projet);

        } else if ("update".equals(action)) {
            int idProjet = Integer.parseInt(request.getParameter("idProjet"));
            String nom = request.getParameter("nomProjet");
            String description = request.getParameter("description");
            Date dateDebut = Date.valueOf(request.getParameter("dateDebut"));
            Date dateFin = Date.valueOf(request.getParameter("dateFin"));
            int budget = Integer.parseInt(request.getParameter("budget"));

            Projet projet = new Projet( nom, description, dateDebut, dateFin, budget);
            projet.setIdProjet(idProjet);
             projetDAO.updateProjet(projet);

        }
        response.sendRedirect(request.getContextPath() + "/projets");
    }
}
package com.example.constructionxpert.controllers;

import com.example.constructionxpert.DAO.ProjetDAO;
import com.example.constructionxpert.Models.Projet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/projets")
public class ProjetServlet extends HttpServlet {
    private ProjetDAO projetDAO;

    @Override
    public void init() {
        projetDAO = new ProjetDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Projet> projets = projetDAO.getAllProjects();
        request.setAttribute("projets", projets);
        request.getRequestDispatcher("projet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            // Create a new project
            int idProjet = Integer.parseInt(request.getParameter("idProjet"));
            String nomProjet = request.getParameter("nomProjet");
            String description = request.getParameter("description");
            String dateDebut = request.getParameter("dateDebut");
            String dateFin = request.getParameter("dateFin");
            int budget = Integer.parseInt(request.getParameter("budget"));

            Projet projet = new Projet();
            projet.setIdProjet(idProjet);
            projet.setNomProjet(nomProjet);
            projet.setDescription(description);
            projet.setDateDebut(java.sql.Date.valueOf(dateDebut));
            projet.setDateFin(java.sql.Date.valueOf(dateFin));
            projet.setBudget(budget);

            boolean isCreated = projetDAO.createProject(projet);
            if (isCreated) {
                response.sendRedirect("projets");
            } else {
                request.setAttribute("error", "Erreur lors de la création du projet.");
                request.getRequestDispatcher("projet.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            // Update an existing project
            int idProjet = Integer.parseInt(request.getParameter("idProjet")); // Add idProjet
            String nomProjet = request.getParameter("nomProjet");
            String description = request.getParameter("description");
            String dateDebut = request.getParameter("dateDebut");
            String dateFin = request.getParameter("dateFin");
            int budget = Integer.parseInt(request.getParameter("budget"));

            Projet projet = new Projet();
            projet.setIdProjet(idProjet); // Set idProjet
            projet.setNomProjet(nomProjet);
            projet.setDescription(description);
            projet.setDateDebut(java.sql.Date.valueOf(dateDebut));
            projet.setDateFin(java.sql.Date.valueOf(dateFin));
            projet.setBudget(budget);

            boolean isUpdated = projetDAO.updateProject(projet);
            if (isUpdated) {
                response.sendRedirect("projets");
            } else {
                request.setAttribute("error", "Erreur lors de la mise à jour du projet.");
                request.getRequestDispatcher("projet.jsp").forward(request, response);
            }
        } else if ("delete".equals(action)) {
            // Delete a project
            int idProjet = Integer.parseInt(request.getParameter("idProjet")); // Change to idProjet

            boolean isDeleted = projetDAO.deleteProject(Integer.parseInt(String.valueOf(idProjet)));
            if (isDeleted) {
                response.sendRedirect("projets");
            } else {
                request.setAttribute("error", "Erreur lors de la suppression du projet.");
                request.getRequestDispatcher("projet.jsp").forward(request, response);
            }
        }
    }
}
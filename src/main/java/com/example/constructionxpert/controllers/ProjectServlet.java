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

@WebServlet("/projects")
public class ProjectServlet extends HttpServlet {
    private ProjetDAO projectDAO;

    @Override
    public void init() {
        projectDAO = new ProjetDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Projet> projects = projectDAO.getAllProjects();
        request.setAttribute("projects", projects);
        request.getRequestDispatcher("project.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            // Créer un nouveau projet
            String nomProjet = request.getParameter("nomProjet");
            String description = request.getParameter("description");
            String dateDebut = request.getParameter("dateDebut");
            String dateFin = request.getParameter("dateFin");
            int budget = Integer.parseInt(request.getParameter("budget"));

            Projet project = new Projet();
            project.setNomProjet(nomProjet);
            project.setDescription(description);
            project.setDateDebut(java.sql.Date.valueOf(dateDebut)); // Convertir String en Date
            project.setDateFin(java.sql.Date.valueOf(dateFin)); // Convertir String en Date
            project.setBudget(budget);

            boolean isCreated = projectDAO.createProject(project);
            if (isCreated) {
                response.sendRedirect("projects");
            } else {
                request.setAttribute("error", "Erreur lors de la création du projet.");
                request.getRequestDispatcher("project.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            // Mettre à jour un projet existant
            String nomProjet = request.getParameter("nomProjet");
            String description = request.getParameter("description");
            String dateDebut = request.getParameter("dateDebut");
            String dateFin = request.getParameter("dateFin");
            int budget = Integer.parseInt(request.getParameter("budget"));

            Projet project = new Projet();
            project.setNomProjet(nomProjet);
            project.setDescription(description);
            project.setDateDebut(java.sql.Date.valueOf(dateDebut)); // Convertir String en Date
            project.setDateFin(java.sql.Date.valueOf(dateFin)); // Convertir String en Date
            project.setBudget(budget);

            boolean isUpdated = projectDAO.updateProject(project);
            if (isUpdated) {
                response.sendRedirect("projects");
            } else {
                request.setAttribute("error", "Erreur lors de la mise à jour du projet.");
                request.getRequestDispatcher("project.jsp").forward(request, response);
            }
        } else if ("delete".equals(action)) {
            // Supprimer un projet
            String nomProjet = request.getParameter("nomProjet");

            boolean isDeleted = projectDAO.deleteProject(nomProjet);
            if (isDeleted) {
                response.sendRedirect("projects");
            } else {
                request.setAttribute("error", "Erreur lors de la suppression du projet.");
                request.getRequestDispatcher("project.jsp").forward(request, response);
            }
        }
    }
}
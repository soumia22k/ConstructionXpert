package com.example.constructionxpert.controllers;
import com.example.constructionxpert.DAO.RessourceDAO;
import com.example.constructionxpert.Models.Ressource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;

@WebServlet("/resources")
public class ResourceServlet extends HttpServlet {
    private RessourceDAO resourceDAO;

    @Override
    public void init() {
        resourceDAO = new RessourceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ressource> resources = resourceDAO.getAllResources();
        request.setAttribute("resources", resources);
        request.getRequestDispatcher("resource.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            // Créer une nouvelle ressource
            String nomRessource = request.getParameter("nomRessource");
            String typeRessource = request.getParameter("typeRessource");
            int quantite = Integer.parseInt(request.getParameter("quantite"));

            Ressource resource;
            resource = new Ressource();
            resource.setNomRessource(nomRessource);
            resource.setTypeRessource(typeRessource);
            resource.setQuantite(quantite);

            boolean isCreated = resourceDAO.createResource(resource);
            if (isCreated) {
                response.sendRedirect("resources");
            } else {
                request.setAttribute("error", "Erreur lors de la création de la ressource.");
                request.getRequestDispatcher("resource.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            // Mettre à jour une ressource existante
            String nomRessource = request.getParameter("nomRessource");
            String typeRessource = request.getParameter("typeRessource");
            int quantite = Integer.parseInt(request.getParameter("quantite"));

            Ressource resource = new Ressource();
            resource.setNomRessource(nomRessource);
            resource.setTypeRessource(typeRessource);
            resource.setQuantite(quantite);

            boolean isUpdated = resourceDAO.updateResource(resource);
            if (isUpdated) {
                response.sendRedirect("resources");
            } else {
                request.setAttribute("error", "Erreur lors de la mise à jour de la ressource.");
                request.getRequestDispatcher("resource.jsp").forward(request, response);
            }
        } else if ("delete".equals(action)) {
            // Supprimer une ressource
            String nomRessource = request.getParameter("nomRessource");

            boolean isDeleted = resourceDAO.deleteResource(nomRessource);
            if (isDeleted) {
                response.sendRedirect("resources");
            } else {
                request.setAttribute("error", "Erreur lors de la suppression de la ressource.");
                request.getRequestDispatcher("resource.jsp").forward(request, response);
            }
        }
    }
}
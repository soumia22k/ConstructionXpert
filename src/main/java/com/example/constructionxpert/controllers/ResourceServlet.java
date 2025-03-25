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
    private RessourceDAO ressourceDAO;

    @Override
    public void init() {
        ressourceDAO = new RessourceDAO();
    }

    // Méthodes privées pour chaque opération CRUD
    private void createResource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ressource.jsp").forward(req, resp);
    }

    private void readResources(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ressource> resources = ressourceDAO.getAllResources();
        req.setAttribute("resources", resources);
        req.getRequestDispatcher("listeRessource.jsp").forward(req, resp);
    }

    private void updateResource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idRessource = Integer.parseInt(req.getParameter("id"));
        Ressource ressource = ressourceDAO.getRessourceById(idRessource);
        req.setAttribute("resource", ressource);
        req.getRequestDispatcher("modifierRessource.jsp").forward(req, resp);
    }

    private void deleteResource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idRessource = Integer.parseInt(req.getParameter("id"));
        boolean isDeleted = ressourceDAO.deleteRessource(idRessource);
        if (isDeleted) {
            resp.sendRedirect("resources");
        } else {
            req.setAttribute("error", "Erreur lors de la suppression de la ressource.");
            readResources(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action != null ? action : "") {
            case "create":
                createResource(request, response);
                break;
            case "read":
                readResources(request, response);
                break;
            case "update":
                updateResource(request, response);
                break;
            case "delete":
                deleteResource(request, response);
                break;
            default:
                readResources(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String nomRessource = request.getParameter("nomRessource");
            String typeRessource = request.getParameter("typeRessource");
            int quantite = Integer.parseInt(request.getParameter("quantite"));

            Ressource ressource = new Ressource(0, nomRessource, typeRessource, quantite);
            boolean isCreated = ressourceDAO.createRessource(ressource);
            if (!isCreated) {
                request.setAttribute("error", "Erreur lors de la création de la ressource.");
            }
        } else if ("update".equals(action)) {
            int idRessource = Integer.parseInt(request.getParameter("idRessource"));
            String nomRessource = request.getParameter("nomRessource");
            String typeRessource = request.getParameter("typeRessource");
            int quantite = Integer.parseInt(request.getParameter("quantite"));

            Ressource ressource = new Ressource(idRessource, nomRessource, typeRessource, quantite);
            boolean isUpdated = ressourceDAO.updateRessource(ressource);
            if (!isUpdated) {
                request.setAttribute("error", "Erreur lors de la mise à jour de la ressource.");
            }
        }
        response.sendRedirect(request.getContextPath() + "/resources");
    }
}
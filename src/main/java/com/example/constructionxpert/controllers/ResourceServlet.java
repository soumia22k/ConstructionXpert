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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action != null ? action : "") {
            case "edit":
                int idRessource = Integer.parseInt(request.getParameter("id"));
                Ressource ressource = ressourceDAO.getRessourceById(idRessource);
                request.setAttribute("resource", ressource);
                request.getRequestDispatcher("modifierRessource.jsp").forward(request, response);
                break;
            default:
                List<Ressource> resources = ressourceDAO.getAllResources();
                request.setAttribute("resources", resources);
                request.getRequestDispatcher("listeRessource.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action != null ? action : "") {
            case "create":
                String nomRessourceCreate = request.getParameter("nomRessource");
                String typeRessourceCreate = request.getParameter("typeRessource");
                int quantiteCreate = Integer.parseInt(request.getParameter("quantite"));

                Ressource ressourceCreate = new Ressource(0, nomRessourceCreate, typeRessourceCreate, quantiteCreate);
                boolean isCreated = ressourceDAO.createRessource(ressourceCreate);
                if (isCreated) {
                    response.sendRedirect("resources");
                } else {
                    request.setAttribute("error", "Erreur lors de la création de la ressource.");
                    request.getRequestDispatcher("ressource.jsp").forward(request, response);
                }
                break;

            case "update":
                int idRessourceUpdate = Integer.parseInt(request.getParameter("idRessource"));
                String nomRessourceUpdate = request.getParameter("nomRessource");
                String typeRessourceUpdate = request.getParameter("typeRessource");
                int quantiteUpdate = Integer.parseInt(request.getParameter("quantite"));

                Ressource ressourceUpdate = new Ressource(idRessourceUpdate, nomRessourceUpdate, typeRessourceUpdate, quantiteUpdate);
                boolean isUpdated = ressourceDAO.updateRessource(ressourceUpdate);
                if (isUpdated) {
                    response.sendRedirect("resources");
                } else {
                    request.setAttribute("error", "Erreur lors de la mise à jour de la ressource.");
                    request.setAttribute("resource", ressourceUpdate);
                    request.getRequestDispatcher("modifierRessource.jsp").forward(request, response);
                }
                break;

            case "delete":
                int idRessourceDelete = Integer.parseInt(request.getParameter("idRessource"));
                boolean isDeleted = ressourceDAO.deleteRessource(idRessourceDelete);
                if (isDeleted) {
                    response.sendRedirect("resources");
                } else {
                    request.setAttribute("error", "Erreur lors de la suppression de la ressource.");
                    doGet(request, response);
                }
                break;

            default:
                // Optionally handle invalid actions here, though in this case, it could just do nothing
                break;
        }
    }
}
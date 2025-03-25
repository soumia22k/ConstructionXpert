package com.example.constructionxpert.controllers;

import com.example.constructionxpert.DAO.ProjetDAO;
import com.example.constructionxpert.DAO.RessourceDAO;
import com.example.constructionxpert.DAO.TacheDAO;
import com.example.constructionxpert.Models.Tache;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/taches")
public class TacheServlet extends HttpServlet {
    private TacheDAO tacheDAO;
    private ProjetDAO projetDAO;
    private RessourceDAO ressourceDAO;

    @Override
    public void init() {
        tacheDAO = new TacheDAO();
        projetDAO = new ProjetDAO();
        ressourceDAO = new RessourceDAO();
    }

    // Méthodes privées pour chaque opération CRUD
    private void createTache(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("projets", projetDAO.getAllProjects());
        req.setAttribute("resources", ressourceDAO.getAllResources());
        req.getRequestDispatcher("tache.jsp").forward(req, resp);
    }

    private void readTaches(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tache> taches = tacheDAO.getAllTasks();
        req.setAttribute("taches", taches);
        req.getRequestDispatcher("listeTache.jsp").forward(req, resp);
    }

    private void updateTache(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idTache = Integer.parseInt(req.getParameter("id"));
        Tache tache = tacheDAO.getTacheById(idTache);
        req.setAttribute("tache", tache);
        req.setAttribute("projets", projetDAO.getAllProjects());
        req.setAttribute("resources", ressourceDAO.getAllResources());
        req.getRequestDispatcher("modifierTache.jsp").forward(req, resp);
    }

    private void deleteTache(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idTache = Integer.parseInt(req.getParameter("id"));
        boolean isDeleted = tacheDAO.deleteTache(idTache);
        if (isDeleted) {
            resp.sendRedirect("taches");
        } else {
            req.setAttribute("error", "Erreur lors de la suppression de la tâche.");
            readTaches(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action != null ? action : "") {
            case "create":
                createTache(request, response);
                break;
            case "read":
                readTaches(request, response);
                break;
            case "update":
                updateTache(request, response);
                break;
            case "delete":
                deleteTache(request, response);
                break;
            default:
                readTaches(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String nomTache = request.getParameter("nomTache");
            String description = request.getParameter("description");
            Date dateDebut = Date.valueOf(request.getParameter("dateDebut"));
            Date dateFin = Date.valueOf(request.getParameter("dateFin"));
            int idRessource = Integer.parseInt(request.getParameter("idRessource"));
            int idProjet = Integer.parseInt(request.getParameter("idProjet"));

            Tache tache = new Tache(0, nomTache, description, dateDebut, dateFin, idRessource, idProjet);
            boolean isCreated = tacheDAO.createTache(tache);
            if (!isCreated) {
                request.setAttribute("error", "Erreur lors de la création de la tâche.");
            }
        } else if ("update".equals(action)) {
            int idTache = Integer.parseInt(request.getParameter("idTache"));
            String nomTache = request.getParameter("nomTache");
            String description = request.getParameter("description");
            Date dateDebut = Date.valueOf(request.getParameter("dateDebut"));
            Date dateFin = Date.valueOf(request.getParameter("dateFin"));
            int idRessource = Integer.parseInt(request.getParameter("idRessource"));
            int idProjet = Integer.parseInt(request.getParameter("idProjet"));

            Tache tache = new Tache(idTache, nomTache, description, dateDebut, dateFin, idRessource, idProjet);
            boolean isUpdated = tacheDAO.updateTache(tache);
            if (!isUpdated) {
                request.setAttribute("error", "Erreur lors de la mise à jour de la tâche.");
            }
        }
        response.sendRedirect(request.getContextPath() + "/taches");
    }
}
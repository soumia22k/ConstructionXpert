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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("edit".equals(action)) {
            int idTache = Integer.parseInt(request.getParameter("id"));
            Tache tache = tacheDAO.getTacheById(idTache);
            request.setAttribute("tache", tache);
            request.setAttribute("projets", projetDAO.getAllProjects());
            request.setAttribute("resources", ressourceDAO.getAllResources());
            request.getRequestDispatcher("modifierTache.jsp").forward(request, response);
        } else {
            List<Tache> taches = tacheDAO.getAllTasks();
            request.setAttribute("taches", taches);
            request.getRequestDispatcher("listeTache.jsp").forward(request, response);
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
            if (isCreated) {
                response.sendRedirect("taches");
            } else {
                request.setAttribute("error", "Erreur lors de la création de la tâche.");
                request.setAttribute("projets", projetDAO.getAllProjects());
                request.setAttribute("resources", ressourceDAO.getAllResources());
                request.getRequestDispatcher("tache.jsp").forward(request, response);
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
            if (isUpdated) {
                response.sendRedirect("taches");
            } else {
                request.setAttribute("error", "Erreur lors de la mise à jour de la tâche.");
                request.setAttribute("tache", tache);
                request.setAttribute("projets", projetDAO.getAllProjects());
                request.setAttribute("resources", ressourceDAO.getAllResources());
                request.getRequestDispatcher("modifierTache.jsp").forward(request, response);
            }
        } else if ("delete".equals(action)) {
            int idTache = Integer.parseInt(request.getParameter("idTache"));
            boolean isDeleted = tacheDAO.deleteTache(idTache);
            if (isDeleted) {
                response.sendRedirect("taches");
            } else {
                request.setAttribute("error", "Erreur lors de la suppression de la tâche.");
                doGet(request, response);
            }
        }
    }
}
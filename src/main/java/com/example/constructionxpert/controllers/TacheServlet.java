package com.example.constructionxpert.controllers;
import com.example.constructionxpert.DAO.TacheDAO;
import com.example.constructionxpert.Models.Tache;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.security.sasl.SaslException;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/tasks")
public class TacheServlet extends HttpServlet {
    private TacheDAO taskDAO;

    @Override
    public void init() {
        taskDAO = new TacheDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SaslException, IOException, ServletException {
        String projectName = request.getParameter("projectName");
        boolean tache = TacheDAO.getTacheByProject(projectName);
        request.setAttribute("tasks", tache);
        request.getRequestDispatcher("task.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            // Créer une nouvelle tâche
            String nomTache = request.getParameter("nomTache");
            String description = request.getParameter("description");
            String dateDebut = request.getParameter("dateDebut");
            String dateFin = request.getParameter("dateFin");
            String ressource = request.getParameter("ressource");
            String projectName = request.getParameter("projectName");

            Tache task = new Tache();
            task.setNomTache(nomTache);
            task.setDescription(description);
            task.setDateDebut(Date.valueOf(dateDebut)); // Convertir String en Date
            task.setDateFin(Date.valueOf(dateFin)); // Convertir String en Date
            task.setRessource(ressource);

            boolean isCreated = taskDAO.createTache(task, projectName);
            if (isCreated) {
                response.sendRedirect("tasks?projectName=" + projectName);
            } else {
                request.setAttribute("error", "Erreur lors de la création de la tâche.");
                request.getRequestDispatcher("task.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            // Mettre à jour une tâche existante
            String nomTache = request.getParameter("nomTache");
            String description = request.getParameter("description");
            String dateDebut = request.getParameter("dateDebut");
            String dateFin = request.getParameter("dateFin");
            String ressource = request.getParameter("ressource");
            String projectName = request.getParameter("projectName");

            Tache Tache = new Tache();
            Tache.setNomTache(nomTache);
            Tache.setDescription(description);
            Tache.setDateDebut(Date.valueOf(dateDebut)); // Convertir String en Date
            Tache.setDateFin(Date.valueOf(dateFin)); // Convertir String en Date
            Tache.setRessource(ressource);

            boolean isUpdated = taskDAO.updateTache(Tache, projectName);
            if (isUpdated) {
                response.sendRedirect("tasks?projectName=" + projectName);
            } else {
                request.setAttribute("error", "Erreur lors de la mise à jour de la tâche.");
                request.getRequestDispatcher("task.jsp").forward(request, response);
            }
        } else if ("delete".equals(action)) {
            // Supprimer une tâche
            String nomTache = request.getParameter("nomTache");
            String projectName = request.getParameter("projectName");

            boolean isDeleted = false;
            try {
                isDeleted = taskDAO.deleteTache( nomTache);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (isDeleted) {
                response.sendRedirect("tasks?projectName=" + projectName);
            } else {
                request.setAttribute("error", "Erreur lors de la suppression de la tâche.");
                request.getRequestDispatcher("task.jsp").forward(request, response);
            }
        }
    }
}
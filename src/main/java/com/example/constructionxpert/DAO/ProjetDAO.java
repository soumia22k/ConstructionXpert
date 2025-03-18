package com.example.constructionxpert.DAO;
import com.example.constructionxpert.Connection.ConnectionDb;
import com.example.constructionxpert.Models.Projet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDAO {



    // Creer

    public boolean createProject(Projet project) {
        String sql = "INSERT INTO Projet (nomProjet, description, dateDebut, dateFin, budget) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, project.getNomProjet());
            pstmt.setString(2, project.getDescription());
            pstmt.setDate(3, new Date(project.getDateDebut().getTime()));
            pstmt.setDate(4, new Date(project.getDateFin().getTime()));
            pstmt.setInt(5, project.getBudget());
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }



    //Afficher

    public List<Projet> getAllProjects() {
        List<Projet> projects = new ArrayList<>();
        String sql = "SELECT * FROM Projet";

        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Projet project = new Projet();
                project.setNomProjet(rs.getString("nomProjet"));
                project.setDescription(rs.getString("description"));
                project.setDateDebut(rs.getDate("dateDebut"));
                project.setDateFin(rs.getDate("dateFin"));
                project.setBudget(rs.getInt("budget"));
                projects.add(project);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return projects;
    }


    //Modifier

    public boolean updateProject(Projet project) {
        String sql = "UPDATE Projet SET description = ?, dateDebut = ?, dateFin = ?, budget = ? WHERE nomProjet = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, project.getDescription());
            pstmt.setDate(2, new java.sql.Date(project.getDateDebut().getTime()));
            pstmt.setDate(3, new java.sql.Date(project.getDateFin().getTime()));
            pstmt.setInt(4, project.getBudget());
            pstmt.setString(5, project.getNomProjet());
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

    //supprimer

    public boolean deleteProject(String nomProjet) {
        String sql = "DELETE FROM Projet WHERE nomProjet = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nomProjet);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }



}

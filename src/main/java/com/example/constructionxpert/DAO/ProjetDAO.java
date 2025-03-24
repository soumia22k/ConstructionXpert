package com.example.constructionxpert.DAO;

import com.example.constructionxpert.Connection.ConnectionDb;
import com.example.constructionxpert.Models.Projet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDAO {

    // Create
    public boolean createProjet(Projet projet) {
        String sql = "INSERT INTO projet (nomProjet, description, dateDebut, dateFin, budget) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, projet.getNomProjet());
            pstmt.setString(2, projet.getDescription());
            pstmt.setDate(3, new java.sql.Date(projet.getDateDebut().getTime()));
            pstmt.setDate(4, new java.sql.Date(projet.getDateFin().getTime()));
            pstmt.setInt(5, projet.getBudget());
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    projet.setIdProjet(rs.getInt(1));
                }
            }
            return rowsInserted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read all projects
    public List<Projet> getAllProjects() {
        List<Projet> projets = new ArrayList<>();
        String sql = "SELECT * FROM projet";
        try (Connection conn = ConnectionDb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Projet projet = new Projet();
                projet.setIdProjet(rs.getInt("idProjet"));
                projet.setNomProjet(rs.getString("nomProjet"));
                projet.setDescription(rs.getString("description"));
                projet.setDateDebut(rs.getDate("dateDebut"));
                projet.setDateFin(rs.getDate("dateFin"));
                projet.setBudget(rs.getInt("budget"));
                projets.add(projet);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return projets;
    }

    // Read by ID
    public Projet getProjetById(int idProjet) {
        Projet projet = null;
        String sql = "SELECT * FROM projet WHERE idProjet = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idProjet);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                projet = new Projet();
                projet.setIdProjet(rs.getInt("idProjet"));
                projet.setNomProjet(rs.getString("nomProjet"));
                projet.setDescription(rs.getString("description"));
                projet.setDateDebut(rs.getDate("dateDebut"));
                projet.setDateFin(rs.getDate("dateFin"));
                projet.setBudget(rs.getInt("budget"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return projet;
    }

    // Update
    public boolean updateProjet(Projet projet) {
        String sql = "UPDATE projet SET nomProjet = ?, description = ?, dateDebut = ?, dateFin = ?, budget = ? WHERE idProjet = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, projet.getNomProjet());
            pstmt.setString(2, projet.getDescription());
            pstmt.setDate(3, new java.sql.Date(projet.getDateDebut().getTime()));
            pstmt.setDate(4, new java.sql.Date(projet.getDateFin().getTime()));
            pstmt.setInt(5, projet.getBudget());
            pstmt.setInt(6, projet.getIdProjet());
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete
    public boolean deleteProjet(int idProjet) {
        String sql = "DELETE FROM projet WHERE idProjet = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idProjet);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
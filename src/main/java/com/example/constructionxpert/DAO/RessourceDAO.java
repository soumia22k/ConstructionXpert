package com.example.constructionxpert.DAO;

import com.example.constructionxpert.Connection.ConnectionDb;
import com.example.constructionxpert.Models.Ressource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RessourceDAO {

    // Create
    public boolean createRessource(Ressource ressource) {
        String sql = "INSERT INTO ressource (nomRessource, typeRessource, quantite) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, ressource.getNomRessource());
            pstmt.setString(2, ressource.getTypeRessource());
            pstmt.setInt(3, ressource.getQuantite());
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    ressource.setIdRessource(rs.getInt(1));
                }
            }
            return rowsInserted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read all resources
    public List<Ressource> getAllResources() {
        List<Ressource> ressources = new ArrayList<>();
        String sql = "SELECT * FROM ressource";
        try (Connection conn = ConnectionDb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Ressource ressource = new Ressource();
                ressource.setIdRessource(rs.getInt("idRessource"));
                ressource.setNomRessource(rs.getString("nomRessource"));
                ressource.setTypeRessource(rs.getString("typeRessource"));
                ressource.setQuantite(rs.getInt("quantite"));
                ressources.add(ressource);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ressources;
    }

    // Read by ID
    public Ressource getRessourceById(int idRessource) {
        Ressource ressource = null;
        String sql = "SELECT * FROM ressource WHERE idRessource = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idRessource);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                ressource = new Ressource();
                ressource.setIdRessource(rs.getInt("idRessource"));
                ressource.setNomRessource(rs.getString("nomRessource"));
                ressource.setTypeRessource(rs.getString("typeRessource"));
                ressource.setQuantite(rs.getInt("quantite"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ressource;
    }

    // Update
    public boolean updateRessource(Ressource ressource) {
        String sql = "UPDATE ressource SET nomRessource = ?, typeRessource = ?, quantite = ? WHERE idRessource = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ressource.getNomRessource());
            pstmt.setString(2, ressource.getTypeRessource());
            pstmt.setInt(3, ressource.getQuantite());
            pstmt.setInt(4, ressource.getIdRessource());
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete
    public boolean deleteRessource(int idRessource) {
        String sql = "DELETE FROM ressource WHERE idRessource = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idRessource);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
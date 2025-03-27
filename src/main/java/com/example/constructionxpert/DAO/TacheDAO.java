package com.example.constructionxpert.DAO;

import com.example.constructionxpert.Connection.ConnectionDb;
import com.example.constructionxpert.Models.Tache;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TacheDAO {

    // Create
    public boolean createTache(Tache tache) {
        String sql = "INSERT INTO tache (nomTache, description, dateDebut, dateFin, idRessource, idProjet) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, tache.getNomTache());
            pstmt.setString(2, tache.getDescription());
            pstmt.setDate(3, new java.sql.Date(tache.getDateDebut().getTime()));
            pstmt.setDate(4, new java.sql.Date(tache.getDateFin(              ).getTime()));
            pstmt.setInt(5, tache.getIdRessource());
            pstmt.setInt(6, tache.getIdProjet());
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    tache.setIdTache(rs.getInt(1));
                }
            }
            return rowsInserted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read all tasks
    public List<Tache> getAllTasks() {
        List<Tache> taches = new ArrayList<>();
        String sql = "SELECT * FROM tache";
        try (Connection conn = ConnectionDb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tache tache = new Tache();
                tache.setIdTache(rs.getInt("idTache"));
                tache.setNomTache(rs.getString("nomTache"));
                tache.setDescription(rs.getString("description"));
                tache.setDateDebut(rs.getDate("dateDebut"));
                tache.setDateFin(rs.getDate("dateFin"));
                tache.setIdRessource(rs.getInt("idRessource"));
                tache.setIdProjet(rs.getInt("idProjet"));
                taches.add(tache);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return taches;
    }

    // Read by ID
    public Tache getTacheById(int idTache) {
        Tache tache = null;
        String sql = "SELECT * FROM tache WHERE idTache = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idTache);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tache = new Tache();
                tache.setIdTache(rs.getInt("idTache"));
                tache.setNomTache(rs.getString("nomTache"));
                tache.setDescription(rs.getString("description"));
                tache.setDateDebut(rs.getDate("dateDebut"));
                tache.setDateFin(rs.getDate("dateFin"));
                tache.setIdRessource(rs.getInt("idRessource"));
                tache.setIdProjet(rs.getInt("idProjet"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tache;
    }



    // Update
    public boolean updateTache(Tache tache) {
        String sql = "UPDATE tache SET nomTache = ?, description = ?, dateDebut = ?, dateFin = ?, idRessource = ?, idProjet = ? WHERE idTache = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tache.getNomTache());
            pstmt.setString(2, tache.getDescription());
            pstmt.setDate(3, new java.sql.Date(tache.getDateDebut().getTime()));
            pstmt.setDate(4, new java.sql.Date(tache.getDateFin().getTime()));
            pstmt.setInt(5, tache.getIdRessource());
            pstmt.setInt(6, tache.getIdProjet());
            pstmt.setInt(7, tache.getIdTache());
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete
    public boolean deleteTache(int idTache) {
        String sql = "DELETE FROM tache WHERE idTache = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idTache);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
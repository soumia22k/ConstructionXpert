package com.example.constructionxpert.DAO;

import com.example.constructionxpert.Connection.ConnectionDb;
import com.example.constructionxpert.Models.Tache;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TacheDAO {

    // Create
    public boolean createTache(Tache tache, int idProjet) {
        String sql = "INSERT INTO Tache (nomTache, description, dateDebut, dateFin, ressource, idProjet) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, tache.getNomTache());
            pstmt.setString(2, tache.getDescription());
            pstmt.setDate(3, new java.sql.Date(tache.getDateDebut().getTime()));
            pstmt.setDate(4, new java.sql.Date(tache.getDateFin().getTime()));
            pstmt.setString(5, tache.getRessource());
            pstmt.setInt(6, idProjet); // Utiliser idProjet
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

    // Read
    public List<Tache> getTacheByProject(String nomProjet) {
        List<Tache> tasks = new ArrayList<>();
        String sql = "SELECT * FROM Tache WHERE nomProjet = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nomProjet);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Tache task = new Tache();
                task.setIdTache(rs.getInt("idTache"));
                task.setNomTache(rs.getString("nomTache"));
                task.setDescription(rs.getString("description"));
                task.setDateDebut(rs.getDate("dateDebut"));
                task.setDateFin(rs.getDate("dateFin"));
                task.setRessource(rs.getString("ressource"));
                tasks.add(task);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    // Update
    public boolean updateTache(Tache tache, String nomProjet) {
        String sql = "UPDATE Tache SET nomTache = ?, description = ?, dateDebut = ?, dateFin = ?, ressource = ? WHERE idTache = ? AND nomProjet = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tache.getNomTache());
            pstmt.setString(2, tache.getDescription());
            pstmt.setDate(3, new java.sql.Date(tache.getDateDebut().getTime()));
            pstmt.setDate(4, new java.sql.Date(tache.getDateFin().getTime()));
            pstmt.setString(5, tache.getRessource());
            pstmt.setInt(6, tache.getIdTache());
            pstmt.setString(7, nomProjet);
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete
    public boolean deleteTache(int idTache, String nomProjet) throws ClassNotFoundException {
        String sql = "DELETE FROM Tache WHERE idTache = ? AND nomProjet = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idTache);
            pstmt.setString(2, nomProjet);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
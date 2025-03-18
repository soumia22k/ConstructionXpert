package com.example.constructionxpert.DAO;

import com.example.constructionxpert.Connection.ConnectionDb;
import com.example.constructionxpert.Models.Tache;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TacheDAO {



    //Creer

    public boolean createTache(Tache tache, String projectName) {
        String sql = "INSERT INTO Tache (nomTache, description, dateDebut, dateFin, ressource, nomProjet) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tache.getNomTache());
            pstmt.setString(2, tache.getDescription());
            pstmt.setDate(3, new java.sql.Date(tache.getDateDebut().getTime()));
            pstmt.setDate(4, new java.sql.Date(tache.getDateFin().getTime()));
            pstmt.setString(5, tache.getRessource());
            pstmt.setString(6, projectName);
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }


    //Afficher

    public static boolean getTacheByProject(String nomProjet) {
        List<Tache> tasks = new ArrayList<>();
        String sql = "SELECT * FROM Tache WHERE nomProjet = ?";

        DatabaseMetaData ConnectionDb = null;
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nomProjet);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Tache task = new Tache();
                task.setNomTache(rs.getString("nomTache"));
                task.setDescription(rs.getString("description"));
                task.setDateDebut(rs.getDate("dateDebut"));
                task.setDateFin(rs.getDate("dateFin"));
                task.setRessource(rs.getString("ressource"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        //Modifier

        public boolean updateTache(Tache tache, String nomProjet) {
            String sql = "UPDATE Tache SET description = ?, dateDebut = ?, dateFin = ?, ressource = ? WHERE nomTache = ? AND nomProjet = ?";
            try (Connection conn = ConnectionDb.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, tache.getDescription());
                pstmt.setDate(2, new Date(tache.getDateDebut().getTime()));
                pstmt.setDate(3, new Date(tache.getDateFin().getTime()));
                pstmt.setString(4, tache.getRessource());
                pstmt.setString(5, tache.getNomTache());
                pstmt.setString(6, nomProjet);
                int rowsUpdated = pstmt.executeUpdate();
                return rowsUpdated > 0;
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }

        //Supprimer

        public boolean deleteTache(String nomProjet) throws ClassNotFoundException {
            String sql = "DELETE FROM Tache WHERE nomTache = ? AND nomProjet = ?";
            try (Connection conn = ConnectionDb.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nomProjet);
                pstmt.setString(2, nomProjet);
                int rowsDeleted = pstmt.executeUpdate();
                return rowsDeleted > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

    }

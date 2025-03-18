package com.example.constructionxpert.DAO;
import com.example.constructionxpert.Connection.ConnectionDb;
import com.example.constructionxpert.Models.Ressource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RessourceDAO {


    // Ajouter une ressource


    public boolean createResource(Ressource resource) {
        String sql = "INSERT INTO Ressource (nomRessource, typeRessource, quantite) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, resource.getNomRessource());
            pstmt.setString(2, resource.getTypeRessource());
            pstmt.setInt(3, resource.getQuantite());
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Récupérer toutes les ressources
    public List<Ressource> getAllResources() {
        List<Ressource> resources = new ArrayList<>();
        String sql = "SELECT * FROM Ressource";

        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Ressource resource = new Ressource();
                resource.setNomRessource(rs.getString("nomRessource"));
                resource.setTypeRessource(rs.getString("typeRessource"));
                resource.setQuantite(rs.getInt("quantite"));
                resources.add(resource);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resources;
    }



    // Récupérer une ressource par son nom

    public Ressource getResourceByName(String nomRessource) {
        Ressource resource = null;
        String sql = "SELECT * FROM Ressource WHERE nomRessource = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nomRessource);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                resource = new Ressource();
                resource.setNomRessource(rs.getString("nomRessource"));
                resource.setTypeRessource(rs.getString("typeRessource"));
                resource.setQuantite(rs.getInt("quantite"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resource;
    }

    // Mettre à jour


    public boolean updateResource(Ressource resource) {
        String sql = "UPDATE Ressource SET typeRessource = ?, quantite = ? WHERE nomRessource = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, resource.getTypeRessource());
            pstmt.setInt(2, resource.getQuantite());
            pstmt.setString(3, resource.getNomRessource());
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Supprimer


    public boolean deleteResource(String nomRessource) {
        String sql = "DELETE FROM Ressource WHERE nomRessource = ?";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nomRessource);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
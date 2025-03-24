package com.example.constructionxpert.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectionDb {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/constructionxpert", "root", "");

        // Create tables only if they don't exist (should ideally be in a separate setup script)
        try (Statement statement = connection.createStatement()) {

            String projetTable = "CREATE TABLE IF NOT EXISTS projet ("
                    + "idProjet INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nomProjet VARCHAR(100), "
                    + "description VARCHAR(200), "
                    + "dateDebut DATE, "
                    + "dateFin DATE, "
                    + "budget INT)";
            statement.execute(projetTable);


            String tacheTable = "CREATE TABLE IF NOT EXISTS tache ("
                    + "idTache INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nomTache VARCHAR(100), "
                    + "description VARCHAR(200), "
                    + "idRessource INT, " // Remplace "ressource  par une clé étrangère
                    + "dateDebut DATE, "
                    + "dateFin DATE, "
                    + "idProjet INT, "
                    + "FOREIGN KEY (idProjet) REFERENCES projet(idProjet) ON DELETE CASCADE, "
                    + "FOREIGN KEY (idRessource) REFERENCES ressource(idRessource) ON DELETE SET NULL)"; // Lien avec ressource
            statement.execute(tacheTable);


            String ressourceTable = "CREATE TABLE IF NOT EXISTS ressource ("
                    + "idRessource INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nomRessource VARCHAR(100) not null, "
                    +"typeRessource VARCHAR(50) not null,"
                    +"quantite INT not null)";
            statement.execute(ressourceTable);


            System.out.println("connected");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed to connect to database");
        }

        return connection;
    }
}
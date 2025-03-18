package com.example.constructionxpert.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDb {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ConstructionXpert", "root", "");

        Statement statement = connection.createStatement();

        String Projettable = "CREATE TABLE IF NOT EXISTS Projet(" +
                "nomProjet VARCHAR(100)," +
                "description VARCHAR(200)," +
                "datdeDebut DATE(20)," +
                "datdeFin DATE(20)," +
                "budget INT (50))";
        statement.execute(Projettable);

        String Tachtable = "CREATE TABLE IF NOT EXISTS Tache("+
                "nomTache VARCHAR (100)"+
                "description VARCHAR(200))"+
                "ressource VARCHAR(80))"+
                "dateDebut DATE (20))"+
                "dateFin DATE (20))";
        statement.execute(Tachtable);

        String RessourceTable="CREATE TABLE IF NOT EXISTS Ressource("+
                "nomRessource VARCHAR(100)," +
                "typeRessource VARCHAR(100)," +
                "quantite INT (100)";

        statement.execute(RessourceTable);

        String AdminTable="CREATE TABLE IF NOT EXISTS Admin("+
                "email VARCHAR(100)," +
                "password VARCHAR(100)," ;

        statement.execute(AdminTable);




        return connection;
    }
}


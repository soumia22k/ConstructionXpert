<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Tâches</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .actions {
            white-space: nowrap;
        }
        .actions button {
            padding: 5px 10px;
            margin: 2px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .actions button:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Liste des Tâches pour le projet : ${param.nomProjet}</h1>

<!-- Lien pour ajouter une nouvelle tâche -->
<p><a href="taches.jsp?nomProject=${param.nomProjet}">Ajouter une nouvelle tâche</a></p>

<!-- Tableau pour afficher les tâches -->
<table>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Description</th>
        <th>Date de début</th>
        <th>Date de fin</th>
        <th>Ressource</th>
        <th>Actions</th>
    </tr>
    <tr>
        <td>${tache.idTache}</td>
        <td>${tache.nomTache}</td>
        <td>${tache.description}</td>
        <td>${tache.dateDebut}</td>
        <td>${tache.dateFin}</td>
        <td>${tache.ressource}</td>
        <td class="actions">
            <!-- Formulaire pour modifier une tâche -->
            <form action="taches" method="post" style="display:inline;">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="idTache" value="${tache.idTache}">
                <input type="hidden" name="nomProjet" value="${param.nomProjet}">
                <button type="submit">Modifier</button>
            </form>
            <!-- Formulaire pour supprimer une tâche -->
            <form action="taches" method="post" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="idTache" value="${tache.idTache}">
                <input type="hidden" name="nomProjet" value="${param.nomProjet}">
                <button type="submit">Supprimer</button>
            </form>
        </td>
    </tr>
</table>

<!-- Affichage des erreurs -->
<p class="error">${error}</p>
</body>
</html>
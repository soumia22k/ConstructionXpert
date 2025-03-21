<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une Tâche</title>
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
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], input[type="date"], textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<h1>Ajouter une Tâche pour le projet : ${param.nomProjet}</h1>

<!-- Formulaire pour ajouter une nouvelle tâche -->
<form action="taches" method="post">
    <input type="hidden" name="action" value="create">
    <input type="hidden" name="nomProject" value="${param.nomProjet}">

    <label for="idTache">ID de la tâche:</label>
    <input type="number" id="idTache" name="idTache" required><br><br>

    <label for="nomTache">Nom de la tâche:</label>
    <input type="text" id="nomTache" name="nomTache" required><br><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br><br>

    <label for="dateDebut">Date de début:</label>
    <input type="date" id="dateDebut" name="dateDebut" required><br><br>

    <label for="dateFin">Date de fin:</label>
    <input type="date" id="dateFin" name="dateFin" required><br><br>

    <label for="ressource">Ressource:</label>
    <input type="text" id="ressource" name="ressource" required><br><br>

    <button type="submit">Ajouter</button>
</form>

<!-- Lien pour afficher la liste des tâches -->
<p><a href="tachesListe.jsp?nomProject=${param.nomProjet}">Voir la liste des tâches</a></p>

<!-- Affichage des erreurs -->
<p class="error">${error}</p>
</body>
</html>
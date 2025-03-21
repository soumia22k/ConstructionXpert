<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  tagdir=""%>
<html>
<head>
    <title>Gestion des Tâches</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">Gestion des Tâches</h1>
    <a href="tasks?action=create&projectName=${param.projectName}" class="btn btn-success mb-3">Créer une nouvelle tâche</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Nom de la Tâche</th>
            <th>Description</th>
            <th>Date de Début</th>
            <th>Date de Fin</th>
            <th>Ressource</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${task.nomTache}</td>
            <td>${task.description}</td>
            <td>${task.dateDebut}</td>
            <td>${task.dateFin}</td>
            <td>${task.ressource}</td>
            <td>
                <a href="tasks?action=update&nomTache=${task.nomTache}&projectName=${param.projectName}" class="btn btn-warning">Modifier</a>
                <a href="tasks?action=delete&nomTache=${task.nomTache}&projectName=${param.projectName}" class="btn btn-danger">Supprimer</a>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="alert alert-danger">${error}</div>
</div>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.example.constructionxpert.Models.Projet" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Projets</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('assets/images/img.jpg');
            background-size: cover;
            background-position: center;
        }
        .table-container {
            background: rgba(0, 0, 0, 0.6);
            padding: 30px;
            border-radius: 10px;
            color: white;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">ConstructionXpert 📝🖊</a>
        <div class="d-flex">
            <a href="index.jsp" class="btn btn-secondary me-2">Accueil</a>
            <div class="dropdown me-2">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="projetsDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                    Projets
                </button>
                <ul class="dropdown-menu" aria-labelledby="projetsDropdown">
                    <li><a class="dropdown-item" href="projets">Liste des Projets</a></li>
                    <li><a class="dropdown-item" href="projets?action=create">Ajouter un Projet</a></li>
                </ul>
            </div>
            <div class="dropdown me-2">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="tachesDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                    Tâches
                </button>
                <ul class="dropdown-menu" aria-labelledby="tachesDropdown">
                    <li><a class="dropdown-item" href="taches">Liste des Tâches</a></li>
                    <li><a class="dropdown-item" href="taches?action=create">Ajouter une Tâche</a></li>
                </ul>
            </div>
            <div class="dropdown me-2">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="resourcesDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                    Ressources
                </button>
                <ul class="dropdown-menu" aria-labelledby="resourcesDropdown">
                    <li><a class="dropdown-item" href="resources">Liste des Ressources</a></li>
                    <li><a class="dropdown-item" href="resources?action=create">Ajouter une Ressource</a></li>
                </ul>
            </div>
            <a href="login.jsp" class="btn btn-secondary">Login</a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <div class="table-container">
                <h2 class="text-center">Liste des Projets</h2>
                <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
                <% } %>
                <table class="table table-dark table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Description</th>
                        <th>Date Début</th>
                        <th>Date Fin</th>
                        <th>Budget</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<Projet> projets = (List<Projet>) request.getAttribute("projets");
                        if (projets != null) {
                            for (Projet projet : projets) {
                    %>
                    <tr>
                        <td><%= projet.getIdProjet() %></td>
                        <td><%= projet.getNomProjet() %></td>
                        <td><%= projet.getDescription() %></td>
                        <td><%= projet.getDateDebut() %></td>
                        <td><%= projet.getDateFin() %></td>
                        <td><%= projet.getBudget() %></td>
                        <td>
                            <a href="projets?action=update&id=<%= projet.getIdProjet() %>" class="btn btn-warning btn-sm">Modifier</a>
                            <a href="projets?action=delete&id=<%= projet.getIdProjet() %>" class="btn btn-danger btn-sm" onclick="return confirm('Voulez-vous vraiment supprimer ce projet ?');">Supprimer</a>
                        </td>
                    </tr>
                    <%      }
                    }
                    %>
                    </tbody>
                </table>
                <div class="text-center">
                    <a href="projet.jsp" class="btn btn-primary">Ajouter un Projet</a>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="text-center mt-5 p-3 bg-light">
    <p>© 2025 | ConstructionXpert | Address: 2602-Beni Mellal</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
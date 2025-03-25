<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier un Projet</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('assets/images/img.jpg');
            background-size: cover;
            background-position: center;
        }
        .form-container {
            background: rgba(0, 0, 0, 0.6);
            padding: 30px;
            border-radius: 10px;
            color: white;
        }
        .form-control {
            background: white;
            color: black;
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
                    <li><a class="dropdown-item" href="/taches">Liste des Tâches</a></li>
                    <li><a class="dropdown-item" href="/taches?action=create">Ajouter une Tâche</a></li>
                </ul>
            </div>
            <div class="dropdown me-2">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="resourcesDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                    Ressources
                </button>
                <ul class="dropdown-menu" aria-labelledby="resourcesDropdown">
                    <li><a class="dropdown-item" href="/resources">Liste des Ressources</a></li>
                    <li><a class="dropdown-item" href="/resources?action=create">Ajouter une Ressource</a></li>
                </ul>
            </div>
            <a href="login.jsp" class="btn btn-secondary">Login</a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="form-container">
                <h2 class="text-center">Modifier le Projet</h2>
                <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
                <% } %>
                <form action="projets" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="idProjet" value="${projet.idProjet}">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label class="form-label">Nom de Projet</label>
                                <input type="text" name="nomProjet" class="form-control" value="${projet.nomProjet}" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Description</label>
                                <textarea name="description" class="form-control" required>${projet.description}</textarea>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label class="form-label">Date de Début</label>
                                <input type="date" name="dateDebut" class="form-control" value="${projet.dateDebut}" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Date de Fin</label>
                                <input type="date" name="dateFin" class="form-control" value="${projet.dateFin}" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Budget</label>
                                <input type="number" name="budget" class="form-control" value="${projet.budget}" required>
                            </div>
                        </div>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Mettre à jour</button>
                        <a href="projets" class="btn btn-secondary">Annuler</a>
                    </div>
                </form>
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
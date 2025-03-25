<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.example.constructionxpert.Models.Tache" %>
<%@ page import="com.example.constructionxpert.Models.Projet" %>
<%@ page import="com.example.constructionxpert.Models.Ressource" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Modifier une Tâche</title>
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
          <li><a class="dropdown-item" href="listeProjet.jsp">Liste des Projets</a></li>
          <li><a class="dropdown-item" href="ajouterProjet.jsp">Ajouter un Projet</a></li>
        </ul>
      </div>
      <div class="dropdown me-2">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="tachesDropdown" data-bs-toggle="dropdown" aria-expanded="false">
          Tâches
        </button>
        <ul class="dropdown-menu" aria-labelledby="tachesDropdown">
          <li><a class="dropdown-item" href="listeTache.jsp">Liste des Tâches</a></li>
          <li><a class="dropdown-item" href="tache.jsp">Ajouter une Tâche</a></li>
        </ul>
      </div>
      <div class="dropdown me-2">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="resourcesDropdown" data-bs-toggle="dropdown" aria-expanded="false">
          Ressources
        </button>
        <ul class="dropdown-menu" aria-labelledby="resourcesDropdown">
          <li><a class="dropdown-item" href="listeRessource.jsp">Liste des Ressources</a></li>
          <li><a class="dropdown-item" href="ressource.jsp">Ajouter une Ressource</a></li>
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
        <h2 class="text-center">Modifier la Tâche</h2>
        <form action="/taches" method="post">
          <input type="hidden" name="action" value="update">
          <% Tache tache = (Tache) request.getAttribute("tache"); %>
          <input type="hidden" name="idTache" value="<%= tache.getIdTache() %>">
          <div class="row">
            <div class="col-md-6">
              <div class="mb-3">
                <label class="form-label">Nom de la Tâche</label>
                <input type="text" name="nomTache" class="form-control" value="<%= tache.getNomTache() %>" required>
              </div>
              <div class="mb-3">
                <label class="form-label">Description</label>
                <textarea name="description" class="form-control" required><%= tache.getDescription() %></textarea>
              </div>
            </div>
            <div class="col-md-6">
              <div class="mb-3">
                <label class="form-label">Date de début</label>
                <input type="date" name="dateDebut" class="form-control" value="<%= tache.getDateDebut() %>" required>
              </div>
              <div class="mb-3">
                <label class="form-label">Date de Fin</label>
                <input type="date" name="dateFin" class="form-control" value="<%= tache.getDateFin() %>" required>
              </div>
              <div class="mb-3">
                <label class="form-label">Ressource</label>
                <select name="idRessource" class="form-control" required>
                  <%
                    List<Ressource> resources = (List<Ressource>) request.getAttribute("resources");
                    if (resources != null) {
                      for (Ressource ressource : resources) {
                        String selected = ressource.getIdRessource() == tache.getIdRessource() ? "selected" : "";
                  %>
                  <option value="<%= ressource.getIdRessource() %>" <%= selected %>><%= ressource.getNomRessource() %></option>
                  <%
                      }
                    }
                  %>
                </select>
              </div>
              <div class="mb-3">
                <label class="form-label">Projet</label>
                <select name="idProjet" class="form-control" required>
                  <%
                    List<Projet> projets = (List<Projet>) request.getAttribute("projets");
                    if (projets != null) {
                      for (Projet projet : projets) {
                        String selected = projet.getIdProjet() == tache.getIdProjet() ? "selected" : "";
                  %>
                  <option value="<%= projet.getIdProjet() %>" <%= selected %>><%= projet.getNomProjet() %></option>
                  <%
                      }
                    }
                  %>
                </select>
              </div>
            </div>
          </div>
          <div class="text-center">
            <button type="submit" class="btn btn-primary">Mettre à jour</button>
            <a href="listeTache.jsp" class="btn btn-secondary">Annuler</a>
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Ressources</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">Liste des Ressources</h1>
    <a href="ressource.jsp" class="btn btn-success mb-3">Ajouter une Ressource</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Type</th>
            <th>Quantité</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${ressource.idRessource}</td>
            <td>${ressource.nomRessource}</td>
            <td>${ressource.typeRessource}</td>
            <td>${ressource.quantite}</td>
            <td>
                <a href="resources?action=edit&id=${ressource.idRessource}" class="btn btn-warning btn-sm">Modifier</a>
                <form action="resources" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="idRessource" value="${ressource.idRessource}">
                    <button type="submit" class="btn btn-danger btn-sm">Supprimer</button>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="alert alert-danger mt-3">${error}</div>
</div>
</body>
</html>
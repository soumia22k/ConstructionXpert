<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${empty resource ? 'Ajouter une Ressource' : 'Modifier une Ressource'}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">${empty resource ? 'Ajouter une Ressource' : 'Modifier une Ressource'}</h1>
    <form action="resources" method="post">
        <input type="hidden" name="action" value="${empty resource ? 'create' : 'update'}">
        <input type="hidden" name="idRessource" value="${resource.idRessource}">
        <div class="mb-3">
            <label for="nomRessource" class="form-label">Nom de la Ressource</label>
            <input type="text" class="form-control" id="nomRessource" name="nomRessource" value="${resource.nomRessource}" required>
        </div>
        <div class="mb-3">
            <label for="typeRessource" class="form-label">Type de Ressource</label>
            <input type="text" class="form-control" id="typeRessource" name="typeRessource" value="${resource.typeRessource}" required>
        </div>
        <div class="mb-3">
            <label for="quantite" class="form-label">Quantité</label>
            <input type="number" class="form-control" id="quantite" name="quantite" value="${resource.quantite}" required>
        </div>
        <button type="submit" class="btn btn-primary">${empty resource ? 'Ajouter' : 'Modifier'}</button>
    </form>
    <div class="alert alert-danger mt-3">${error}</div>
</div>
</body>
</html>
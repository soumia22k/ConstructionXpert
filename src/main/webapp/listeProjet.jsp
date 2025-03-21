<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Form</title>
</head>
<body>
<h1>${action == 'create' ? 'Create' : 'Edit'} Project</h1>
<form action="projets" method="post">
    <input type="hidden" name="action" value="${action}">
    <c:if test="${action == 'update'}">
        <input type="hidden" name="idProjet" value="${projet.idProjet}">
    </c:if>
    <label for="nomProjet">Name:</label>
    <input type="text" id="nomProjet" name="nomProjet" value="${projet.nomProjet}" required><br><br>
    <label for="description">Description:</label>
    <textarea id="description" name="description" required>${projet.description}</textarea><br><br>
    <label for="dateDebut">Start Date:</label>
    <input type="date" id="dateDebut" name="dateDebut" value="${projet.dateDebut}" required><br><br>
    <label for="dateFin">End Date:</label>
    <input type="date" id="dateFin" name="dateFin" value="${projet.dateFin}" required><br><br>
    <label for="budget">Budget:</label>
    <input type="number" id="budget" name="budget" value="${projet.budget}" required><br><br>
    <button type="submit">${action == 'create' ? 'Create' : 'Update'}</button>
</form>
<p style="color: red;">${error}</p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            background-image: url("assets/images/img.jpg");
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 160vh;
            margin: 0;
        }
        header {
            background-color: #f9fffe;
            color: #000000;
            padding: 10px 20px;
            width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: fixed;
            top: 0;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        header h1 {
            margin: 0;
            font-size: 24px;
        }
        header nav {
            display: flex;
            gap: 20px;
        }
        header nav a {
            color: white;
            text-decoration: none;
            font-size: 16px;
        }
        header nav a:hover {
            text-decoration: underline;
        }
        .login-container {
            background-image:url("assets/images/img.jpg") ;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
            margin-top: 80px; /* Pour éviter que le header ne chevauche le formulaire */
        }
        .login-container h1 {
            margin-bottom: 20px;
            font-size: 24px;
            color: #333;
        }
        .login-container label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }
        .login-container input[type="email"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        .login-container button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        .login-container button:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: red;
            margin-top: 10px;
        }
        footer {
            background-color: #333;
            color: white;
            padding: 10px 0;
            width: 100%;
            text-align: center;
            position: fixed;
            bottom: 0;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">ConstructionXpert 📝🖊</a>
        <div class="d-flex">
            <a href="/index.jsp" class="btn btn-secondary me-2">Accueil</a>
            <div class="dropdown me-2">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="projetsDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                    Projets
                </button>
                <ul class="dropdown-menu" aria-labelledby="projetsDropdown">
                    <li><a class="dropdown-item" href="/projets">Liste des Projets</a></li>
                    <li><a class="dropdown-item" href="/projets?action=create">Ajouter un Projet</a></li>
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
            <a href="/login.jsp" class="btn btn-secondary">Login</a>
        </div>
    </div>
</nav>

<div class="login-container">
    <h1>Login</h1>
    <form action="admin" method="post">
        <input type="hidden" name="action" value="login">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <button type="submit">Login</button>
    </form>
    <p class="error-message">
        <c:if test="${not empty param.error}">
            Email ou mot de passe incorrect.
        </c:if>
    </p>
</div>

<footer>
    <p>© 2025 | ConstructionXpert | Address: 2602-Beni Mellal</p>
</footer>
</body>
</html>
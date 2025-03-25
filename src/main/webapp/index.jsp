<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ConstructionXpert</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-image: url("assets/images/img.jpg");
            background-size: cover;
            background-position: center;
            border-radius: 20px;

        }


        .overlay {
            background: rgba(0, 0, 0, 0.6);
            color: white;
            padding: 50px 20px;
            text-align: center;
        }
        .feature-box {
            background: rgba(0, 0, 0, 0.7);
            padding: 20px;
            border-radius: 10px;
        }
        .feature-box img {
            max-width: 100%;
            height: auto;
            transition: transform 0.3s ease;
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

<div class="overlay">
    <h1><strong>ConstructionXpert</strong></h1>
    <p>"Votre allié pour des projets maîtrisés, où planification, collaboration et suivi se rencontrent pour bâtir l'excellence, sans stress 📋🖋️💻."</p>
</div>

<div class="container mt-5">
    <div class="row">
        <div class="col-md-4">
            <div class="feature-box text-white">
                <h4>Planification des tâches et des ressources :</h4>
                <img src="assets/images/plan.jpg" class="img-fluid1" alt="Planification">
            </div>
        </div>
        <div class="col-md-4">
            <div class="feature-box text-white">
                <h4>Suivi et collaboration en temps réel :</h4>
                <img src="assets/images/suivie.jpg" class="img-fluid2" alt="Collaboration">
            </div>
        </div>
        <div class="col-md-4">
            <div class="feature-box text-white">
                <h4>Reporting et analyse des performances :</h4>
                <img src="/assets/images/img1.jpg" class="img-fluid3" alt="Reporting">
            </div>
        </div>
    </div>
</div>

<footer class="text-center mt-5 p-3 bg-light">
    <p>&copy; 2025 | ConstructionXpert | Address: 2602-Beni Mellal</p>
</footer>
</body>
</html>

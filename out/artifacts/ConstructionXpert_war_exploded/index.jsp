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
        <div>
            <a href="projet.jsp" class="btn btn-secondary">Projets</a>
            <a href="login.jsp" class="btn btn-secondary">Login</a>
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
                <img src="https://i.pinimg.com/474x/e7/50/7b/e7507b62b8e4efbc760f799fb08f0c34.jpg" class="img-fluid1" alt="Planification">
            </div>
        </div>
        <div class="col-md-4">
            <div class="feature-box text-white">
                <h4>Suivi et collaboration en temps réel :</h4>
                <img src="https://i.pinimg.com/474x/e3/1d/fc/e31dfc432441c2713c6eba69b602ce42.jpg" class="img-fluid2" alt="Collaboration">
            </div>
        </div>
        <div class="col-md-4">
            <div class="feature-box text-white">
                <h4>Reporting et analyse des performances :</h4>
                <img src="https://i.pinimg.com/474x/79/70/73/7970730f1521ed036775c34bb67eeae6.jpg" class="img-fluid3" alt="Reporting">
            </div>
        </div>
    </div>
</div>

<footer class="text-center mt-5 p-3 bg-light">
    <p>&copy; 2025 | ConstructionXpert | Address: 2602-Beni Mellal</p>
</footer>
</body>
</html>

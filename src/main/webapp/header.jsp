<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="CSS/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="d-flex liens">

		<p class="log">
			<a href="${pageContext.request.contextPath}/Home" class=""> <img
				src="images/logo.png" width="90px" height="90px" class="logo" alt="" />
			</a>
		</p>

		<nav class="mb-3 d-flex p-3">
		
		
		<c:if test="${empty sessionScope.user }">
		<div class="dropdown">
							
							<a href="" class="border border-infos btn btn-secondary  "
								type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false"><i class="fa-solid fa-bars p-1"></i></a>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a
									href="${pageContext.request.contextPath}/UserController?action=inscription"
									class="dropdown-item">Inscription</a>
									<hr style="margin: 0;padding=0;" /></li>
								<li><a
					href="${pageContext.request.contextPath}/UserController?action=connexion"
					class="dropdown-item">Connexion</a>
							</ul>
						</div>
				&nbsp;&nbsp;
		</c:if>
			<c:choose>
				<c:when test="${!empty sessionScope.user }">

					<c:if test="${sessionScope.user.role=='participant'}">
					
						<div>
							<a
								href="${pageContext.request.contextPath}/PlanningController?action=monCalendrier&id=${sessionScope.user.niveau.id_niveaux }"
								class="border border-infos btn btn-outline-warning">Mon
								Calendrier</a>
							<a
								href="${pageContext.request.contextPath}/UserController?action=listeUser"
								class="border border-infos btn btn-outline-warning">Liste Etudiant</a>
								
						</div>

					</c:if>
					<c:if test="${sessionScope.user.role=='admin'}">
				&nbsp;
				<div class="dropdown">
							
							<a href=""
								class="border border-infos btn btn-outline-warning
								dropdown-toggle"
								type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false"> Utilisateur </a>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a
									href="${pageContext.request.contextPath}/UserController?action=listeUsers"
									class="dropdown-item">Liste Utilisateurs</a>
									<hr style="margin: 0;padding=0;" /></li>
								<li><a
									href="${pageContext.request.contextPath}/UserController?action=ajouterUser"
									class="dropdown-item">Ajouter Utilisateur</a></li>
							</ul>
						</div>
				&nbsp;&nbsp;
				<div class="dropdown">
							<a href=""
								class="border border-infos btn btn-outline-warning dropdown-toggle"
								type="" id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false"> Calendrier </a>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a
									href="${pageContext.request.contextPath}/Cours?action=ajouterCours"
									class="dropdown-item">Ajouter un cours</a>
									<hr style="margin: 0;padding=0;" /></li>
								<li><a
									href="${pageContext.request.contextPath}/Cours?action=listeCours"
									class="dropdown-item">Liste des cours</a>
									<hr style="margin: 0;padding=0;" /></li>
								<li><a
									href="${pageContext.request.contextPath}/CalendrierController?action=ajouterCalendrier"
									class="dropdown-item">Ajouter Calendrier </a>
									<hr style="margin: 0;padding=0;" /></li>
								<li><a
									href="${pageContext.request.contextPath}/PlanningController?action=planifier"
									class="dropdown-item">Plannifier Cours</a>
									<hr style="margin: 0;padding=0;" /></li>
								<li><a
									href="${pageContext.request.contextPath}/PlanningController?action=coursPlanifier"
									class="dropdown-item">Cours Planifier</a></li>
							</ul>
						</div>
				&nbsp;&nbsp;
				<div class="dropdown">
							<a href=""
								class="border border-infos btn btn-outline-warning dropdown-toggle"
								type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false"> Niveaux </a>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a
									href="${pageContext.request.contextPath}/NiveauxController?action=ajouterNiveau"
									class="dropdown-item">Ajouter un niveaux</a>
								<hr style="margin: 0;padding=0;" /></li>

								<li><a
									href="${pageContext.request.contextPath}/NiveauxController?action=listeNiveau"
									class="dropdown-item">Liste des Niveaux</a></li>

							</ul>
						</div>
				&nbsp;
				</c:if>
					<div>
						<a
							href="${pageContext.request.contextPath}/UserController?action=deconnexion"
							class="border border-infos btn btn-outline-danger">Deconnexion</a>
					</div>

				</c:when>
			</c:choose>

		</nav>
			<c:if test="${sessionScope.user.role=='admin'}">
				<h6 class="d-block text-center text-primary" style='margin:79px 10px 0px 40px;' ><i class="fa-solid fa-gears">&nbsp;</i><em>Admin: ${sessionScope.user.prenom } ${sessionScope.user.nom }</em></h6>
			</c:if>
			<c:if test="${sessionScope.user.role=='participant'}">
				<h6 class="d-block text-center" style='margin:79px 10px 0px 180px;color:green;'><i class="fa-solid fa-user"></i>&nbsp;<em>Student: ${sessionScope.user.prenom } ${sessionScope.user.nom }</em></h6>
			</c:if>
	</div>
	<hr />
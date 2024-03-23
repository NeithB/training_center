<%@ include file="header.jsp"%>

<title>Liste User</title>

<div class="container">
<h1><i class="fa-solid fa-users"></i>Liste Users ---- Niveau <span style="color:red;"> ${sessionScope.user.niveau.libelle }</span></h1>
<hr class="mb-4" />
	
	
	
	<table class="table">
		<thead>
			<tr class="table table-secondary">
				<th scope="col">ID</th>
				<th scope="col">Nom</th>
				<th scope="col">Prenom</th>
				<th scope="col">Sexe</th>
				<th scope="col">Email</th>
				<th scope="col">Statut</th>
				<th scope="col">Niveau</th>
				
			</tr>
		</thead>
		<c:forEach items="${listeUsers}" var="liste">
		<tbody>
		<c:choose>
		<c:when test="${liste.niveau.id_niveaux== sessionScope.user.niveau.id_niveaux}">
		<c:if test="${liste.role =='participant'}">
			<tr>
				<th scope="row"><c:out value="${liste.id_user }"/></th>
				<td><c:out value="${liste.nom }"/></td>
				<td><c:out value="${liste.prenom }"/></td>
				<td><c:out value="${liste.sexe }"/></td>
				<td><c:out value="${liste.email }"/></td>
				<td><c:out value="${liste.role }"/></td>
				<td><c:out value="${liste.niveau.libelle }"/></td>			
			</tr>
		</c:if>
		</c:when>
		</c:choose>
		</tbody>
		</c:forEach>
	</table>
</div>




</body>
</html>
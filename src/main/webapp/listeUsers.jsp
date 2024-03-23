
<title>Liste Users</title>
<%@ include file="header.jsp"%>



<div class="container">
<h1><i class="fa-solid fa-users"></i>Liste Users</h1>
<hr class="mb-4" />
	
	
	
	<table class="table">
		<thead>
			<tr class="table table-secondary">
				<th scope="col">ID</th>
				<th scope="col">Nom</th>
				<th scope="col">Prenom</th>
				<th scope="col">Sexe</th>
				<th scope="col">login</th>
				<th scope="col">Email</th>
				<th scope="col">Role</th>
				<th scope="col">Niveau</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<c:forEach items="${listeUsers}" var="liste">
		<tbody>
			<tr>
				<th scope="row"><c:out value="${liste.id_user }"/></th>
				<td><c:out value="${liste.nom }"/></td>
				<td><c:out value="${liste.prenom }"/></td>
				<td><c:out value="${liste.sexe }"/></td>
				<td><c:out value="${liste.login }"/></td>
				<td><c:out value="${liste.email }"/></td>
				<td><c:out value="${liste.role }"/></td>
				<td><c:out value="${liste.niveau.libelle }"/></td>
				<td>
					<a href="${pageContext.request.contextPath}/UserController?action=supprimer&id_user=${liste.id_user }"><i class="fa-solid fa-trash"></i></a>
					&nbsp;
					<a href="${pageContext.request.contextPath}/UserController?action=modifier&id_user=${liste.id_user }"><i class="fa-solid fa-pen"></i></a>
				</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
</div>




</body>
</html>
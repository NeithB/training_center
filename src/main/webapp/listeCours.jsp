<title>Liste de cours</title>
<%@ include file="header.jsp"%>



<h1 class="" style="padding-left:30px;"><i class="fa-solid fa-book-open-reader"></i> &nbsp;Liste Cours</h1>
<hr />
<div class="container">
	
	
	
	<table class="table">
		<thead>
			<tr class="table table-secondary">
				<th scope="col">ID</th>
				<th scope="col">titre</th>
				<th scope="col">Admin</th>
				<th scope="col">Niveau</th>
				<th scope="col">Action</th>
				
			</tr>
		</thead>
		 <c:forEach items="${listeCours}" var="liste">
		<tbody>
			<tr>
				<th scope="row"><c:out value="${liste.id_lecon }"/></th>
				<td><c:out value="${liste.titre }"/></td>
				<td><c:out value="${liste.user.prenom }"/></td>
				<td><c:out value="${liste.niveaux.libelle }"/></td>
				<td>
					<a href="${pageContext.request.contextPath}/Cours?action=supprimer&id_cours=${liste.id_lecon }"><i class="fa-solid fa-trash text-danger"></i></a>
					
				</td>
				
			</tr>
		</tbody>
		</c:forEach> 
	</table>
</div>




</body>
</html>
<title>Liste Calendrier</title>
<%@ include file="header.jsp"%>



<div class="container">
<h1>Liste Cours</h1>
	
	
	
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
				<td><c:out value=" "/></td>
				<td><c:out value=""/></td>
				
			</tr>
		</tbody>
		</c:forEach> 
	</table>
</div>




</body>
</html>
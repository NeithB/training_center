
<title>Liste des niveaux</title>
<%@ include file="header.jsp"%>



<div class="container">
<h1>Liste Niveaux</h1>
	
	
	
	
	<table class="table">
		<thead>
			<tr class="table table-secondary">
				<th scope="col">ID</th>
				<th scope="col">Libelle</th>
				<th scope="col">ID Calendar</th>				
				<th scope="col">Action</th>
			</tr>
		</thead>
		<c:forEach items="${listeNiveaux}" var="liste">
		<tbody>
			<tr>
				<th scope="row"><c:out value="${liste.id_niveaux }"/></th>
				<td><c:out value="${liste.libelle}"/></td>
				<td><c:out value="${liste.calendrier.id_calendar }"/></td>
				<td>
					<a href="${pageContext.request.contextPath}/NiveauxController?action=supprimer&id_niveaux=${liste.id_niveaux }"><i class="fa-solid fa-trash text-danger"></i></a>
					
				</td>
			</tr>
		</tbody>
		</c:forEach> 
	</table>
</div>




</body>
</html>
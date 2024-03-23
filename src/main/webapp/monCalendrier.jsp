
<title>Mon calendrier</title>
<%@ include file="header.jsp"%>



<div class="container">
	<h1><i class="fa-regular fa-calendar-days"></i>Mon calendrier</h1>

	<hr class="mb-4" />

	

	<table class="table">
		<thead>
			<tr class="table table-secondary">
				<th scope="col">Date</th>
				<th scope="col">Heure</th>
				<th scope="col">Cours</th>
				<th scope="col">Admin</th>
				<th scope="col">Niveau</th>
				

			</tr>
		</thead>
		<c:forEach items="${listePlanings}" var="liste">
				<c:if test="${liste.lecon.niveaux.id_niveaux==id}">
			<tbody>
					<tr>
						<th scope="row"><em><c:out value="${liste.calendrier.date_calendar }" /></em></th>				
						<td><c:out value="${liste.calendrier.heure_calendar }" /></td>
						<td><c:out value="${liste.lecon.titre }" /></td>
						<td><c:out value="${liste.lecon.user.prenom }  ${liste.lecon.user.nom }" /></td>
						<td><c:out value="${liste.lecon.niveaux.libelle }" /></td>
						
					</tr>
			</tbody>
				</c:if>
		</c:forEach>
	</table>
</div>




</body>
</html>
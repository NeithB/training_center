<title>planier un cours</title>

<%@ include file="header.jsp"%>


<div class="container">
<h1><i class="fa-sharp fa-solid fa-book"></i>&nbsp;Cours Planifiés</h1>
	
	<hr class="mb-4" />
	
	
	
	
	<table class="table">
		<thead>
			<tr class="table table-secondary">
				<th scope="col">Date</th>
				<th scope="col">Heure</th>
				<th scope="col"></th>
				<th scope="col">Cours</th>
				<th scope="col">Admin</th>
				<th scope="col">Niveau</th>
				<th scope="col">Action</th>
				
			</tr>
		</thead>
		 <c:forEach items="${listePlanings}" var="liste">
		<tbody>
				
			<tr>
				<th scope="row"><em><c:out value="${liste.calendrier.date_calendar } "/></em></th>
				<td><c:out value="${liste.calendrier.heure_calendar }"/></td>
				<td>|</td>
				<td class="text-success"><b><c:out value="${liste.lecon.titre }"/></b></td>
				<td><em><c:out value="${liste.lecon.user.prenom }  ${liste.lecon.user.nom }"/></em></td>
				<td><c:out value="${liste.lecon.niveaux.libelle }"/></td>			
				<td>
					<a href="${pageContext.request.contextPath}/PlanningController?action=supprimer&id_lecon=${liste.lecon.id_lecon }&id_calendar=${liste.calendrier.id_calendar }"><i class="fa-solid fa-trash text-danger"></i></a>
				</td>
				
				
			</tr>
			
		</tbody>
		</c:forEach>  
	</table>
</div>




</body>
</html>
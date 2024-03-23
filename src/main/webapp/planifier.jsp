<title>Planifier</title>

<%@ include file="header.jsp"%>



<div class="container">
	<h1><i class="fa-regular fa-calendar-days"></i>Plannifier Cours</h1>

	<hr class="mb-4" />


	<form action="" method="post">
		<div class="row align-items-start d-flex">	
			<div class="form-group text-center col">
				<label for="cours" ><i class="fa-solid fa-book"></i><b>Cours</b></label>
				 <select name="cours" id="" class="form-select">
					<c:forEach items="${listeCours}" var="listeCour">
						<option value="${listeCour.id_lecon}">
							<c:out value="${listeCour.titre} " />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							->						
							<c:out value="${listeCour.niveaux.libelle} " />
						</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group text-center col mb-4">
				<label for="calendrier" ><i class="fa-regular fa-calendar-days"></i><b>Date et Heure</b></label> 
				<select name="calendrier" id="" class="form-select">
					<c:forEach items="${listeCalendars}" var="listeCal">
						<option value="${listeCal.id_calendar}">
							<c:out
								value="Le ${listeCal.date_calendar} à  ${listeCal.heure_calendar} " />
						</option>
					</c:forEach>
				</select>
			</div>
	</div>
			<div class="text-center">
				<input type="submit" class="btn btn-success" name="add" value="planifier cours" />
				<input type="reset" class="btn btn-danger" name="add" />
			</div>
		
	</form>
	
</div>




</body>
</html>
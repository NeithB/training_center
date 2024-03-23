<title>Niveaux</title>
<%@ include file="header.jsp"%>

<main class="container">
	<div class="mt-3 mb-4 container-fluid" style="width: 70%;">
		<h1 class=""><i class="fa-sharp fa-solid fa-gears"></i>&nbsp;Ajouter Niveaux</h1>
		
		
		
		<form action="" method="post">
			<div  class="w-75%">		
			
			<div class="form-group mb-4">
				<label for="">Libelle</label> 
				<input type="text" name="libelle" class="form-control" />
			</div>
				<label for="">Calendrier</label> 
			<div class="form-group mb-4">
				 <select name="niveau" id="" class="form-select">					
			<c:forEach items="${calendriers}" var="calendrier">
						<option value="${calendrier.id_calendar}">
						<c:out value=" ${calendrier.id_calendar}"/>
						</option>				
			</c:forEach>
				</select>
			</div>
			
			<div class="mt-3">
				<input type="submit" class="btn btn-success" name="add" value="Ajouter niveux" /> 			
			</div>
			</div>

		</form>
	</div>

</main>

</body>
</html>
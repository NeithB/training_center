<title>Ajouter Un cours</title>
<%@ include file="header.jsp"%>
<main class="container">
		<h1 class=""><i class="fa-solid fa-book"></i>&nbsp;Ajouter Cours</h1>	
		<hr />
	<div class="mt-3 mb-4 container-fluid" style="width: 70%;">
		
		
		<form action="" method="post">
			<div  class="w-75%">		
			<div hidden class="form-group mb-4">		
				<input type="text" value="${sessionScope.user.id_user }" />			
			</div>

			<div class="form-group mb-4">
				<label for="">Titre</label> 
				<input type="text" name="titre" class="form-control" />
			</div>
			
			<div class="form-group mb-4">
				 <select name="niveau" id="" class="form-select">					
					<c:forEach items="${listesNiveaux}" var="liste">
								<option value="${liste.id_niveaux}">
								<c:out value="${liste.libelle} "/>
								</option>				
					</c:forEach>
				</select>
			</div>
			
			<div class="mt-3">
				<input type="submit" class="btn btn-success" name="add" value="ajouter cours" /> 			
			</div>
			</div>

		</form>
	</div>

</main>

</body>
</html>
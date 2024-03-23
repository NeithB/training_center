<title>Inscription</title>
<%@ include file="header.jsp"%>




<main class="container-fluid">
<h1 class="pl-2"><i class="fa-solid fa-user-pen"></i>Inscription</h1>	
<hr class="mb-1" />
	<div class="mt-3 mb-4 container" style="width: 70%;">
			
		<form action="" method="post">
			<div class="w-75%">
				<div class="d-flex">
					<div class="form-check">
						<input type="radio" value="femme" name="sexe" id="" class="form-check-input" /> 
						<label for="femme">Femme</label>
					</div>

					&nbsp;
					<div class="form-check">
						<input type="radio" value="homme" name="sexe" id="" class="form-check-input" />
						 <label for="homme">Homme</label>
					</div>
				</div>
			</div>


			<div class="form-group">
				<label for="nom">Nom</label> 
				<input type="text" name="nom" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="prenom">Prénom</label> 
				<input type="text" name="prenom" class="form-control" />
			</div>
			<div class="form-group">
				<label for="email">Email</label> 
				<input type="email" name="email" class="form-control" />
			</div>

			<div class="form-group">
				<label for="">Login</label> 
				<input type="text" name="login" class="form-control" />
			</div>

			<div class="form-group">
				<label for="">Password</label>
				 <input type="password" name="mdp" class="form-control" />
			</div>
			<div class="form-group mb-4">
			<label for="">Niveau de calsse</label>
				 <select name="niveau" id="" class="form-select">					
					<c:forEach items="${listesNiveaux}" var="liste">
								<option value="${liste.id_niveaux}">
								<c:out value="${liste.libelle} "/>
								</option>				
					</c:forEach>
				</select>
			</div>
			<div class="mt-3">
				<input type="submit" class="btn btn-success" name="add" value="inscription" /> 
				<input type="reset" class="btn btn-danger" />
			</div>

		</form>
	</div>

</main>

</body>
</html>
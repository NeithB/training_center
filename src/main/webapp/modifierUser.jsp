<title>Modifier User</title>
<%@ include file="header.jsp"%>




<main class="container-fluid">
<h1 class="pl-2"><i class="fa-solid fa-user-pen"></i>Mise à Jour Utilisateur</h1>	
<hr class="mb-1" />
	<div class="mt-3 mb-4 container" style="width: 70%;">			
			
		<form action="" method="post">
			<div class="w-75%">
					<input type="hidden"  name="id" value="${userModifier.id_user}">				
				<div class="d-flex">
				
					<div class="form-check">
						<input type="radio" value="femme" name="sexe" id="" class="form-check-input" ${userModifier.sexe=='femme'? 'checked' : null}   /> 
						<label for="femme">Femme</label>
					</div>
				
					&nbsp;
				
					<div class="form-check">
						<input type="radio" value="homme" name="sexe" id="" class="form-check-input" ${userModifier.sexe=='homme'? 'checked' : null} />
						 <label for="homme">Homme</label>
					</div>
				
				</div>
			</div>


			<div class="form-group">
				<label for="nom">Nom</label> 
				<input type="text" name="nom" value="${userModifier.nom}" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="prenom">Prénom</label> 
				<input type="text" name="prenom" value="${userModifier.prenom}" class="form-control" />
			</div>
			<div class="form-group">
				<label for="email">Email</label> 
				<input type="email" name="email" value="${userModifier.email}" class="form-control" />
			</div>

			<div class="form-group">
				<label for="">Login</label> 
				<input type="text" name="login" value="${userModifier.login}" disabled="disabled" class="form-control" />
			</div>

			<div class="form-group">
				<label for="">Password</label>
				 <input type="password" name="mdp" value="${userModifier.mdp}" disabled="disabled" class="form-control" />
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
				<input type="submit" class="btn btn-success" name="add" value="Modifier" /> 
				<input type="reset" class="btn btn-danger" />
			</div>

		</form>
	</div>

</main>

</body>
</html>
<title>Connexion</title>

<%@ include file="header.jsp"%>

<main class="container">
	<div class="d-flex">
		<h1 >
			<i class="fa-solid fa-right-to-bracket"></i> &nbsp; Connexion
		</h1>
		<a href="UserController?action=inscription" class="text-center"
			style='text-decoration: none; display: inline-block;margin:40px 0px 0px 500px;'> <c:out
				value="Inscrivez-vous si vous n'avez pas de compte" />
		</a>
	</div>
	<hr class="" style='margin-top:-2px' />
	<div class="mt-3 mb-4 container-fluid" style="width: 70%;">


		<form action="" method="post">
			<div class="w-75%">

				<div class="form-group">
					<label for="">Login</label> <input type="text" name="login"
						class="form-control" />
				</div>

				<div class="form-group">
					<label for="">Password</label> <input type="password" name="mdp"
						class="form-control" />
				</div>

				<div class="mt-3">
					<input type="submit" class="btn btn-success" name="add"
						value="se connecter" />
				</div>
			</div>

		</form>
	</div>
			
</main>

</body>
</html>
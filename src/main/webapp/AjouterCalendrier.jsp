<title>Ajouter Un calendrier</title>
<%@ include file="header.jsp"%>
<main class="container">
	<div class="mt-3 mb-4 container-fluid" style="width: 70%;">
		<h1 class="mb-4"><i class="fa-sharp fa-solid fa-calendar-days"></i> Ajouter Calendrier</h1>

		<form action="" method="post">

			<div class="form-group">
			
				<label for="'">Date</label> 
				<input type="Date" name="dateCal" class="form-control" />
			</div>

			<div class="form-group">
				<label for="">Heure</label>
				 <input type="Time" name="heure" class="form-control" />
			</div>		
			<div class="mt-2 ">
				<input type="submit" class="btn btn-success" name="add" value="ajouter calendrier" /> 
				<input type="reset" class="btn btn-danger" />
			</div>

		</form>
	</div>

</main>

</body>
</html>
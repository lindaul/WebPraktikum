<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   
    <title>Electronic Shop Produkt</title>
    
</head>
<body>


<%@ include file="header.jsp"%>


	<div class="container" >
		<div class="row">
			<div class="col-md-5 py-3 py-md-0" id="side1">
				<h3 class="text-center">Administrator</h3>
			</div>
			<div class="col-md-7 py-3 py-md-0" id="side2">

				<h3 class="text-center h1">Product</h3>
				<p class="text-center"></p>
				<div class="">

					<!-- Basic Form -->
					<form class="mb-3" action="./ProduktAppl.jsp">
						<div class="mb-3">
							<label for="produkt" class="form-label">Produkt Name</label> <input
								type="text" name="produktName" class="form-control" />
						</div>
						<div class="mb-3">
							<label for="produkt" class="form-label">Produkt Nummer</label> <input
								type="text" name="produktNummer" class="form-control" />
						</div>
						<div class="mb-3">
							<label for="produkt" class="form-label">Beschreibung</label>
							<textarea name="beschreibung" class="form-control" id="comment" rows="5"></textarea>
						</div>
						<div class="mb-3">
							<label for="produkt" class="form-label">Preis</label> <input
								type="text" name="produktPreis" class="form-control" />
						</div>
						<div class="mb-3">
							<label for="produkt" class="form-label">Bestand</label> <input
								type="text" name="Bestand" class="form-control" />
						</div>
						<div class="mb-3">
							<label for="produkt" class="form-label">Kategorie</label> <input
								type="text" name="kategorie" class="form-control" />
						</div>
						<div class="mb-3">
							<label for="produkt" class="form-label">Marke</label> <input
								type="text" name="marke" class="form-control" />
						</div>
						
						


						<div class="mb-5">
							<input type="submit" value="SAVE" name="btnSaveProdukt"
								class="btn btn-lg btn-primary " />
						</div>

					</form>
				</div>

			</div>


		</div>




	</div>






 




</body>
</html>
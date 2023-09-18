<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Electronic Shop Registrierung</title>

</head>
<body>

	<!-- top navbar -->
	<%@ include file="header.jsp"%>
	<!-- navbar -->








	<div class="container" id="login">
		<div class="row">
			<div class="col-md-5 py-3 py-md-0" id="side1">
				<h3 class="text-center">Register</h3>
			</div>
			<div class="col-md-7 py-3 py-md-0" id="side2">
				<h3 class="text-center h3">SIGN IN</h3>
				<div class="">


					<form class="mb-3" action="./RegisterAppl.jsp">
						<div class="mb-3">
							<label for="text" class="form-label">Vorname</label> <input
								type="text" name="vorname" class="form-control" />
						</div>
						<div class="mb-3">
							<label for="text" class="form-label">Nachname</label> <input
								type="text" name="nachname" class="form-control" />
						</div>
						<div class ="fehlerfeld"></div>
						<div class="mb-3">
							<label for="email" class="form-label">Email Address</label> <input
								type="email" name="email" class="form-control" />
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">Password</label> <input
								type="password" name="password" class="form-control" />
						</div>
						<div class="mb-3">
							<input type="submit" value="Register" name="btnRegister"
								class="btn btn-lg btn-primary" />
						</div>
					</form>


				</div>
			</div>






			<!-- footer -->
			<%@ include file="../html/footer.html"%>
</body>
</html>
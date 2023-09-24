<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   
    <title>Electronic Shop Produkt</title>
    
</head>
<body>
<form action="">

<%@ include file="header.jsp"%>


 <div class="container" id="produkt">
    <div class="row">
        <div class="col-md-5 py-3 py-md-0" id="side1">
            <h3 class="text-center">Administrator</h3>
        </div>
        <div class="col-md-7 py-3 py-md-0" id="side2">
            <h3 class="text-center">Produkt</h3>
            <p class="text-center">Ihre Produkt hinzufügen  </p>
            <div class="input2 text-center">
            Name :<input type="text" name="name" value=""><br>
              ProduktId :<input type="text" name="id" value=""><br>
              Preis :<input type="text" name="preis" value=""><br>
              Bestand :<input type="text" name="bestand" value=""><br>
              Rabatt :<input type="text" name="rabatt" value=""><br>
              Datum :<input type="text" name="datum" value=""><br>
             Kategorie :<input type="text" name="kategorie" value=""><br>
              Marke :<input type="text" name="marke" value=""><br><br>
              
              
              
              
               <button id="speichern">Speichern</button>
              
            </div>
              </div>

    </div>
   </div>


<%@ include file="../html/footer.html"%>
</form>
</body>
</html>
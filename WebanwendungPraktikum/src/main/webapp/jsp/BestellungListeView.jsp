<%@page import="de.hwg_lu.bwi.beans.Warenkorb_Produkt"%>
<%@page import="de.hwg_lu.bwi.beans.WarenkorbBean"%>
<%@page import="de.hwg_lu.bwi.beans.Produkt"%>
<%@page import="de.hwg_lu.bwi.beans.LoginBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Orders</title>
<link rel="stylesheet" href="../css/Bestellung.css">
</head>
<body>
	
	<jsp:useBean id="myProdukt" class="de.hwg_lu.bwi.beans.Produkt"
		scope="session" />
	<jsp:useBean id="myWarenkorb" class="de.hwg_lu.bwi.beans.WarenkorbBean"
		scope="session" />
	<jsp:useBean id="myWarenkorbProdukt"
		class="de.hwg_lu.bwi.beans.Warenkorb_Produkt" scope="session" />


     <!-- top navbar -->
    <%@ include file="header.jsp"%>
   
     <!-- navbar -->
   

 <h1>   

Meine Bestellungen
<br><br>

</h1>

<div id="messagebean">  </div>

<section class="intro">
  <div class="bg-image h-100" style="background-color: #f5f7fa;">
    <div class="mask d-flex align-items-center h-100">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-12">
            <div class="card">
              <div class="card-body p-0">
                <div class="table-responsive table-scroll" data-mdb-perfect-scrollbar="true" style="position: relative; height: 700px">
                  <table class="table table-striped mb-0">
                    <thead style="background-color: rgb(67 0 86);">
                      <tr>
                        
                        <th scope="col">Photo</th>
                        <th scope="col">Produkt Name</th>
                        <th scope="col">Kategorie</th>
                        <th scope="col">Preis</th>
                        <th scope="col">Menge</th>
                        <th scope="col">Gesamt Preis</th>
                        <th scope="col">Status</th>
                        <th scope="col">Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      
                      
                      <jsp:getProperty property="bestellungListe" name="myWarenkorbProdukt"/>
                      
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<%@ include file="../html/footer.html"%>


</body>
</html>
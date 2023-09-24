<%@page import="de.hwg_lu.bwi.beans.KommentarBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> All of the Reviews</title>
<link rel="stylesheet" href="../css/Bestellung.css">
</head>
<body>



	<jsp:useBean id="myProdukt" class="de.hwg_lu.bwi.beans.Produkt"
		scope="session" />
	<jsp:useBean id="myKommentar" class="de.hwg_lu.bwi.beans.KommentarBean"
		scope="session" />
	


     <!-- top navbar -->
    <%@ include file="header.jsp"%>
    
   
     <!-- navbar -->
     
     
 <h1>   Reviews of all Produkt</h1>
<br><br>


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
                        
                        <th scope="col">Product Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Note</th>
                        <th scope="col">Date</th>
                        
                      </tr>
                    </thead>
                    <tbody>
                      <jsp:getProperty property="allKommentar" name="myKommentar"/>
                 
                      
                      
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
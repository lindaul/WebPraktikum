<%@page import="de.hwg_lu.bwi.beans.Warenkorb_Produkt"%>
<%@page import="de.hwg_lu.bwi.beans.Produkt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/ShoppingCart.css">
</head>
<body>
<jsp:useBean id="myProdukt" class="de.hwg_lu.bwi.beans.Produkt" scope="session"/>
<jsp:useBean id="myWarenkorbProdukt" class="de.hwg_lu.bwi.beans.Warenkorb_Produkt" scope="session"/>

    <!-- top navbar -->
    <%@ include file="header.jsp"%>
   
    <!-- navbar -->
 <h1>   

Ansicht f&uuml;r die Warenkorb


</h1>

<section class="h-100 h-custom" style="background-color: #d2c9ff;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12">
        <div class="card card-registration card-registration-2" style="border-radius: 15px;">
          <div class="card-body p-0">
            <div class="row g-0">
              <div class="col-lg-8">
                <div class="p-5">
                 <jsp:getProperty property="headerSummary" name="myWarenkorbProdukt"/>
                  <hr class="my-4">

                  <jsp:getProperty property="shoppingCart" name="myWarenkorbProdukt"/>
                  <hr class="my-4">

                  

                  <div class="pt-5">
                    <h6 class="mb-0"><a href="shoppingCart.jsp" class="text-body"><i
                          class="fas fa-long-arrow-alt-left me-2"></i>Back to shop</a></h6>
                  </div>
                </div>
              </div>
              <jsp:getProperty property="summary" name="myWarenkorbProdukt"/>
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
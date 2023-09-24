 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electronic Shop Header</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/js/all.min.js"></script>
    <!-- bootstrap links -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- end bootstrap links -->
    <!-- fonts links -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Merriweather&display=swap" rel="stylesheet">
    <!--end  fonts links -->
    
</head>
<body>
<jsp:useBean id="myUser" class="de.hwg_lu.bwi.beans.UserBean" scope="session"/>
<jsp:useBean id="myLogin" class="de.hwg_lu.bwi.beans.LoginBean" scope="session"/>
 
    <!-- top navbar -->
    <div class="top-navbar ">
        <jsp:getProperty property="welcomeMessage" name="myLogin"/>
        <div class="icons">
           <jsp:getProperty property="loggedHeaderImage" name="myLogin"/>
            <!-- Warenkorbsymbol -->
           <a href="ShoppingCartAppl.jsp"> <i id="cart-icon" class="fas fa-shopping-cart"> cart </i> </a>
       </div>
    </div>     
    <!-- top navbar -->
 
  
    <!-- navbar -->
    <nav class="navbar navbar-expand-lg" id="navbar">
        <div class="container-fluid">
          <a class="navbar-brand" href="index.jsp" id="logo"><span id="span1">E</span>Lectronic <span>Shop</span></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span><img src="../img/menu.png" alt="" width="30px"></span>
          </button>
          <jsp:getProperty property="navbar" name="myLogin"/>
        </div>
      </nav>
    <!-- navbar -->
    

 

<!-- Warenkorb-Sidebar2 -->
<div id="cart-container" class="cart-container">
<br>
<div> &nbsp; <i id="cart-icon2" class="fas fa-close">  </i></div>
    <!-- Hier wird der Warenkorb-Inhalt angezeigt -->
    <h2>Shopping-cart 2</h2>
        <ul id="cart-items">
            <!-- Hier werden die Warenkorbartikel hinzugefügt -->
        </ul>
</div>


</body>
</html>
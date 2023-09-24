<!DOCTYPE html>
<%@page import="de.hwg_lu.bwi.beans.Produkt"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electronic Shop home</title>
    
    
</head>
<body>
<jsp:useBean id="myProduct" class="de.hwg_lu.bwi.beans.Produkt" scope="session"/>

    <%@ include file="header.jsp"%>




    
    <!-- home content -->
    <section class="home">
    <div class="content">
      <h1> <span>Electronic Products</span>
        <br>
        Up To <span id="span2">50%</span> Off
      </h1>
      <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta, saepe.
        <br>Lorem ipsum dolor sit amet consectetur.
      </p>
      <div class="btn"><button>Shop Now</button></div>

    </div>
    <div class="img">
      <img src="../img/background.png" alt="">
    </div>
  </section>
    <!-- home content -->








    <!-- product cards -->
    <div class="container" id="product-cards">
      <h1 class="text-center">PRODUCTS</h1>
      <div class="row" style="margin-top: 30px;">
       
          
          <jsp:getProperty property="productCard" name="myProduct"/>
      
        </div>
         </div>
         
     
    <!-- product cards -->









    <!-- other cards -->
    <div class="container" id="other-cards">
      <div class="row">
        <div class="col-md-6 py-3 py-md-0">
          <div class="card">
            <img src="../img/c1.png" alt="">
            <div class="card-img-overlay">
              <h3>Best Laptop</h3>
              <h5>Latest Collection</h5>
              <p>Up To 50% Off</p>
              <button id="shopnow">Shop Now</button>
            </div>
          </div>
        </div>
        <div class="col-md-6 py-3 py-md-0">
          <div class="card">
            <img src="../img/c2.png" alt="">
            <div class="card-img-overlay">
              <h3>Best Headphone</h3>
              <h5>Latest Collection</h5>
              <p>Up To 50% Off</p>
              <button id="shopnow">Shop Now</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- other cards -->
   






    <!-- banner -->
    <section class="banner">
      <div class="content">
        <h1> <span>Electronic Gadget</span>
          <br>
          Up To <span id="span2">50%</span> Off
        </h1>
        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta, saepe.
          <br>Lorem ipsum dolor sit amet consectetur.
        </p>
        <div class="btn"><button>Shop Now</button></div>
  
      </div>
      <div class="img">
        <img src="../img/image1.png" alt="">
      </div>
    </section>
    <!-- banner -->








    <!-- product cards -->
    <div class="container" id="product-cards">

      <div class="row" style="margin-top: 30px;">
       
   
     
      

      <!-- other cards -->
    <div class="container" id="other">
      <div class="row">
        <div class="col-md-4 py-3 py-md-0">
          <div class="card">
            <img src="../img/c3.png" alt="">
            <div class="card-img-overlay">
              <h3>Home Gadget</h3>
              <p>Latest collection Up To 50% Off</p>
            </div>
          </div>
        </div>
        <div class="col-md-4 py-3 py-md-0">
          <div class="card">
            <img src="../img/c4.png" alt="">
            <div class="card-img-overlay">
              <h3>Gaming Gadget</h3>
              <p>Latest collection Up To 50% Off</p>
            </div>
          </div>
        </div>
        <div class="col-md-4 py-3 py-md-0">
          <div class="card">
            <img src="../img/c5.png" alt="">
            <div class="card-img-overlay">
              <h3>Electronic Gadget</h3>
              <p>Latest collection Up To 50% Off</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- other cards -->




    <!-- product cards -->









    <!-- offer -->
    <div class="container" id="offer">
      <div class="row">
        <div class="col-md-3 py-3 py-md-0">
          <i class="fa-solid fa-cart-shopping"></i>
          <h3>Free Shipping</h3>
          <p>On order over $1000</p>
        </div>
        <div class="col-md-3 py-3 py-md-0">
          <i class="fa-solid fa-rotate-left"></i>
          <h3>Free Returns</h3>
          <p>Within 30 days</p>
        </div>
        <div class="col-md-3 py-3 py-md-0">
          <i class="fa-solid fa-truck"></i>
          <h3>Fast Delivery</h3>
          <p>World Wide</p>
        </div>
        <div class="col-md-3 py-3 py-md-0">
          <i class="fa-solid fa-thumbs-up"></i>
          <h3>Big choice</h3>
          <p>Of products</p>
        </div>
      </div>
    </div>
    <!-- offer -->


<%@ include file="../html/footer.html"%>

 
</body>
</html>
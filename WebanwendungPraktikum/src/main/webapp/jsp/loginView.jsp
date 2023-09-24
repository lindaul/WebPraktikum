<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electronic Shop Login</title>
    
</head>
<body>

    <!-- top navbar -->
   <%@ include file="header.jsp"%>






    
   <div class="container" id="login">
    <div class="row">
        <div class="col-md-5 py-3 py-md-0" id="side1">
            <h3 class="text-center"> Welcome Back!</h3>
        </div>
        <div class="col-md-7 py-3 py-md-0" id="side2">
        
            <h3 class="text-center h1">LOG IN</h3>
            <p class="text-center"> </p>
            <div class="">
           
                   <!-- Basic Form -->
      <form class="mb-3" action="./LoginAppl.jsp">
        <div class="mb-3">
          <label for="email" class="form-label">Email Address</label>
          <input type="email" name="email" class="form-control" />
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" name="password" class="form-control" />
        </div>
        <div class="mb-3"></div>
         <div class="mb-3"></div>
          <div class="mb-3"></div>
          <div class="mb-3">
              <a  href=".\registerView.jsp" > You dont have an account Sign Up here</a>
        </div>
        
        
        <div class="mb-5">
       <input type="submit" value="Login" name="btnLogin" class="btn btn-lg btn-primary " />
        </div>
      
      </form>
        </div>

    </div>
            
            
            </div>
  
            
            
     
   </div>





  





   <%@ include file="../html/footer.html"%>
</body>
</html>
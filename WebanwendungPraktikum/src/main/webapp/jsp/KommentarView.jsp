
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <!-- top navbar -->
    <%@ include file="header.jsp"%>
   
    <!-- navbar -->
    
    
       <div class="container" id="login">
    <div class="row">
        <div class="col-md-5 py-3 py-md-0" id="side1">
            <h3 class="text-center"> Thank you for your review !</h3>
        </div>
        <div class="col-md-7 py-3 py-md-0" id="side2">
        
            <h3 class="text-center h1">Review your Produkt</h3>
            <p class="text-center"> </p>
            <div class="">
           
                   <!-- Basic Form -->
      <form class="mb-3" action="./KommentarAppl.jsp">
      
      <div class="mb-3">
          <label for="note" class="form-label">Note</label>
         <input type="number" class="form-control" id="numberInput" min="1" max="5" name="bewertung">
        </div>
        <div class="mb-3">
          <label for="comment" class="form-label">Comment: </label>
          <textarea name="beschreibung" class="form-control" id="comment" rows="5"></textarea>
        </div>
        
        <div class="mb-3">
       <input type="submit" value="Send Comment" name="btnComment" class="btn btn-lg btn-primary " />
        </div>
       
      </form>
        </div>

    </div>
            
            
            </div>
  
            
            
     
   </div>
 <%@ include file="../html/footer.html"%>

</body>
</html>
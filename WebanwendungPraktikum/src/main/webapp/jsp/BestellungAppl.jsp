<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<jsp:useBean id="myLogin" class="de.hwg_lu.bwi.beans.LoginBean"
		scope="session" />
	<jsp:useBean id="myProdukt" class="de.hwg_lu.bwi.beans.Produkt"
		scope="session" />
	<jsp:useBean id="myWarenkorb" class="de.hwg_lu.bwi.beans.WarenkorbBean"
		scope="session" />
	<jsp:useBean id="myWarenkorbProdukt"
		class="de.hwg_lu.bwi.beans.Warenkorb_Produkt" scope="session" />

<%
       
String btnBestellen = request.getParameter("bestellen");
if (btnBestellen == null)
	btnBestellen = "";





if(btnBestellen.equals("bestellen") && btnBestellen!= null ){
	
	
	myWarenkorbProdukt.updateStatusprodukt();


	
	
	
	
	response.sendRedirect("./Bestellung.jsp");
	
}


%>

</body>
</html>
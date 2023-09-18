<%@page import="java.sql.SQLException"%>
<%@page import="de.hwg_lu.bwi.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="myUser" class="de.hwg_lu.bwi.beans.UserBean" scope="session"/>

<%
String vorname= request.getParameter("vorname");
String nachname= request.getParameter("nachname");
String email= request.getParameter("email");
String password= request.getParameter("password");
String btnRegister= request.getParameter("btnRegister");

if (btnRegister == null) btnRegister = "";

if(btnRegister.equals("Register")){
	
	myUser.setVorname(vorname);
	myUser.setNachname(nachname);
	myUser.setEmail(email);
	myUser.setPassword(password);
	myUser.setIsAdmin("N");
	
	
	try{
		
		boolean validUser = myUser.insertUserIfNotExists();
		
		if(validUser){
			
			//myUser.insertUserNoCheck();
			response.sendRedirect("./loginView.jsp");
			
		}else{
			response.sendRedirect("./registerView.jsp");
		}
		
	}catch(SQLException e){
		e.printStackTrace();
		response.sendRedirect("./registerView.jsp");
	}
	
	
	
	
}

%>
</body>
</html>
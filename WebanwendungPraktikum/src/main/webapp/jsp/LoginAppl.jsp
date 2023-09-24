<%@page import="java.sql.SQLException"%>
<%@page import="de.hwg_lu.bwi.beans.LoginBean"%>
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
<jsp:useBean id="myLogin" class="de.hwg_lu.bwi.beans.LoginBean" scope="session"/>

<%
String email= request.getParameter("email");
String password= request.getParameter("password");
String btnLogin= request.getParameter("btnLogin");
String btnLogout = request.getParameter("logout");


if (btnLogin == null) btnLogin = "";


	
	



if(btnLogin.equals("Login") && btnLogin != null){
	
	myLogin.setEmail(email);
	myLogin.setPassword(password);
	
	
	try{
		boolean loginGeklappt = myLogin.checkUseridPassword();
		if (loginGeklappt){
			myLogin.setLoggedIn(true);
			/*myMessage.setLoginSuccessful(userid);*/
			response.sendRedirect("./index.jsp");
		}else{
			myLogin.setLoggedIn(false);
			/*myMessage.setLoginFailed();*/
			response.sendRedirect("./loginView.jsp");		
		}
	}catch(SQLException se){
		se.printStackTrace();
		myLogin.setLoggedIn(false);
		/*myMessage.setDBError();*/
		response.sendRedirect("./loginView.jsp");		
	}
	
	
}
	


%>

</body>
</html>
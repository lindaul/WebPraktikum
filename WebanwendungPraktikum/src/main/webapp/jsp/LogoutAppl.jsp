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

String btnLogout = request.getParameter("logout");


if (btnLogout == null) btnLogout = "";

btnLogout = "logout";
	
	
	if(btnLogout.equals("logout") && myLogin.isLoggedIn( ) == true){

			
			myLogin.logout(session);
			myLogin.setLoggedIn(false);
			response.sendRedirect("./index.jsp");
			
			
	
		
		
	}else{
		response.sendRedirect("./index.jsp");
	}

	
	



%>

</body>
</html>
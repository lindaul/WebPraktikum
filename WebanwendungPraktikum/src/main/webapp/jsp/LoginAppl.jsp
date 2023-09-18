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
String email= request.getParameter("email");
String password= request.getParameter("password");
String btnLogin= request.getParameter("btnLogin");


if (btnLogin == null) btnLogin = "";

if(btnLogin.equals("Login")){
	
	
}



%>

</body>
</html>
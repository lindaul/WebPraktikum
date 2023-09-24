<%@page import="de.hwg_lu.bwi.beans.KommentarBean"%>
<%@page import="de.hwg_lu.bwi.beans.Warenkorb_Produkt"%>
<%@page import="de.hwg_lu.bwi.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="myLogin" class="de.hwg_lu.bwi.beans.LoginBean" scope="session"/>
<jsp:useBean id="myWarenkorbProdukt" class="de.hwg_lu.bwi.beans.Warenkorb_Produkt" scope="session" />
<jsp:useBean id="myKomment" class="de.hwg_lu.bwi.beans.KommentarBean" scope="session" />

<%
String stringBewertung= request.getParameter("bewertung");
String beschreibungKommentar= request.getParameter("beschreibung");
String btnComment= request.getParameter("btnComment");



 String  stringIdProdukt= request.getParameter("idProdukt");
 



if (btnComment == null) btnComment = "";


if(btnComment.equals("Send Comment")){
	int bewertung = Integer.parseInt(stringBewertung);
	int userId = myLogin.useridEingeloggt();
	int produktId = Integer.parseInt(stringBewertung);
/*	int produktId = " je dois prendre ca dans le bouton bewertung"*/
	
	myKomment.setBeschreibungKommentar(beschreibungKommentar);
	myKomment.setBewertung(bewertung);
	myKomment.setProducktId(produktId);
	myKomment.setUserId(userId);
	
	
	myKomment.insertKommentarDB();
	//Meassage Bean message de bonne reception
	
	response.sendRedirect("./Bestellung.jsp");
	
	
}else{
	
	
	
	response.sendRedirect("./KommentarView.jsp");
	
	
	
}






%>

</body>
</html>
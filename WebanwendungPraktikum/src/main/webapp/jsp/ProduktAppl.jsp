<%@page import="de.hwg_lu.bwi.beans.Produkt"%>
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
<jsp:useBean id="myProdukt" class="de.hwg_lu.bwi.beans.Produkt" scope="session" />
<jsp:useBean id="myKomment" class="de.hwg_lu.bwi.beans.KommentarBean" scope="session" />



<%
String productName= request.getParameter("produktName");

String produktNummer= request.getParameter("produktNummer");

String beschreibung= request.getParameter("beschreibung");

String Stringbestand= request.getParameter("Bestand");

String kategorie= request.getParameter("kategorie");
String marke= request.getParameter("marke");

String produktPreis= request.getParameter("produktPreis");

String btnSaveProdukt= request.getParameter("btnSaveProdukt");

int bestand = Integer.parseInt(Stringbestand);
double preis = Double.parseDouble(produktPreis);


myProdukt.setProduktName(productName);
myProdukt.setProduktNummer(produktNummer);
myProdukt.setBeschreibungProdukt(beschreibung);
myProdukt.setBestand(bestand);
myProdukt.setKategorie(kategorie);
myProdukt.setMarke(marke);
myProdukt.setPreis(preis);


if (btnSaveProdukt == null)
	btnSaveProdukt = "";

if (btnSaveProdukt.equals("SAVE")) {
	myProdukt.insertProduktDB();


	response.sendRedirect("./index.jsp");

} else {

	response.sendRedirect("./Product.jsp");

}
%>
</body>
</html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>
<%@page import="de.hwg_lu.bwi.beans.Warenkorb_Produkt"%>
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

	<jsp:useBean id="myLogin" class="de.hwg_lu.bwi.beans.LoginBean"
		scope="session" />
	<jsp:useBean id="myProdukt" class="de.hwg_lu.bwi.beans.Produkt"
		scope="session" />
	<jsp:useBean id="myWarenkorb" class="de.hwg_lu.bwi.beans.WarenkorbBean"
		scope="session" />
	<jsp:useBean id="myWarenkorbProdukt"
		class="de.hwg_lu.bwi.beans.Warenkorb_Produkt" scope="session" />





	

	<%
	
	String StringProduktRemoveid = request.getParameter("removeProdukt");
	String btnBestellen = request.getParameter("bestellen");
	if (StringProduktRemoveid == null)
		StringProduktRemoveid = "";

	
	
	String stringProduktid = request.getParameter("btnProduktid");
	if (stringProduktid == null)
		stringProduktid = "";
	
	
	
	
	
	
	
	if (!myLogin.isLoggedIn()) {

		/* send a message with messagebean that user must be connected before putting items in cart */

		response.sendRedirect("./loginView.jsp");

	} else if(StringProduktRemoveid != null && !StringProduktRemoveid.isEmpty()){
		
		 
			    try {
			        int removeproduktid = Integer.parseInt(StringProduktRemoveid);
			        myWarenkorbProdukt.deleteproduktInWarenkorb(removeproduktid);
			        myWarenkorbProdukt.getProduktFromWarenkorbHTML();
			        response.sendRedirect("./shoppingCart.jsp");
			    } catch (NumberFormatException e) {
			        // Gérer l'exception si la conversion échoue (par exemple, afficher un message d'erreur)
			        e.printStackTrace(); // Vous pouvez remplacer ceci par un gestionnaire d'erreur approprié
			    }
			
	}
	else {
		/* Ajouter shopping cart quand */
		
		try{
			ArrayList<Produkt> produktlist = new ArrayList<>();
			
			
			int produktid = Integer.parseInt(stringProduktid);
			
			/*creer une instance pour warenkorb*/

			
			
			

				int idUser = myLogin.useridEingeloggt();
				out.println(idUser + " " + produktid);
				if (stringProduktid != null && idUser != 0) {
					
					
					myWarenkorbProdukt.insertProdukttoWarenkorb(idUser, produktid);
					myWarenkorbProdukt.setUserid(idUser);
					myWarenkorbProdukt.getProduktFromWarenkorbHTML();
					/* if(myWarenkorb.insertcheckWarenkorbDB(idUser)){
					
					warenkorbid = myWarenkorb.getOneWarenkorbDB(idUser).getWarenkorbId();
					newprodukt = myProdukt.getOneProduktFromDB(produktid);
					myProdukt.addProdukttoProduktList(newprodukt);
					}else{
					}
					myProdukt.getOneProduktDB(produktid);
					myWarenkorbProdukt.setProduktId(1);
					myWarenkorbProdukt.setWarenkorbId(1);
					myWarenkorbProdukt.setMenge(2);
					
					 */
					
				
					

					response.sendRedirect("./shoppingCart.jsp");

				} else {

					response.sendRedirect("./index.jsp");
				}
			
			
			
		}
		catch(NumberFormatException e){
			
			e.printStackTrace();
		}

	

	

	}
	%>











	







</body>
</html>